package es.amosrosado.proyecto_java_juego;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class App extends Application {
    
    // Variables finales
    final int ANCHO_ESCENA = 300;
    final int LARGO_ESCENA = 1000;
    
    //Variables
    int soldadoPosY = 195;
    int soldadoPosX = 195;
    int velocidadSoldado = 0;
    
    int municionPosX = 500;
    int municionPosY = 210;
    
    int botiquinPosX = 700;
    int botiquinPosY = 220;
    
    int armaPosX = 900;
    int armaPosY = 230;
    
    ImageView imgViewSoldadoDerecha;
    ImageView imgViewSoldadoIzquierda;
    ImageView imgViewMapa;
    ImageView imgViewMunicion;
    ImageView imgViewBotiquin;
    ImageView imgViewArma;
    
    @Override
    public void start(Stage stage) {
        // Creacion escena
        Pane paneRoot = new Pane();
        Scene scene = new Scene(paneRoot, LARGO_ESCENA, ANCHO_ESCENA);
        scene.setFill(Color.BLACK);
        stage.setTitle("Proyecto");
        stage.setScene(scene);
        stage.show();
        
        //Imagen del Mapa
        Image imagen_Mapa1 = new Image(getClass().getResourceAsStream("/images/Mapa1.jpg"));
        imgViewMapa = new ImageView(imagen_Mapa1);
        paneRoot.getChildren().add(imgViewMapa);
        
        //Imagen del Soldado Derecha
        Image imagenSoldadoDerecha = new Image(getClass().getResourceAsStream("/images/SoldadoDerecha.png"));
        imgViewSoldadoDerecha = new ImageView(imagenSoldadoDerecha);
        
        //Imagen Soladado Izquierda
        Image imagenSoldadoIzquierda = new Image(getClass().getResourceAsStream("/images/SoldadoIzquierda.png"));
        imgViewSoldadoIzquierda = new ImageView(imagenSoldadoIzquierda);
        
        //Englobacion para colisiones imagenes soldados
        Rectangle rectSoldados = new Rectangle(195, 195);
        Group groupRectSoldados = new Group();
        groupRectSoldados.getChildren().addAll(rectSoldados, imgViewSoldadoIzquierda, imgViewSoldadoDerecha);
        
        //Imagen Municion
        Image imagenMunicion = new Image(getClass().getResourceAsStream("/images/Municion.png"));
        imgViewMunicion = new ImageView(imagenMunicion);
        
        //ImagenBotiquin
        Image imagenBotiquin = new Image(getClass().getResourceAsStream("/images/Botiquin.png"));
        imgViewBotiquin = new ImageView(imagenBotiquin);
        
        //Imagen Arma
        Image imagenArma = new Image(getClass().getResourceAsStream("/images/Arma.png"));
        imgViewArma = new ImageView(imagenArma);
        
        //Eleccion aleatoria de objetivos
        Random objetivoRandom = new Random();
        objetivoRandom.nextInt(3);
        
        //Posicion aleatoria de Ojbetivos
        Random posicionRandom = new Random();
        posicionRandom.nextInt(1001);
        
        //if(objetivoRandom == 1) {
            
        //}
        imgViewMunicion.setX(municionPosX);
        imgViewMunicion.setY(municionPosY);
        paneRoot.getChildren().add(imgViewMunicion);
  
        imgViewBotiquin.setX(botiquinPosX);
        imgViewBotiquin.setY(botiquinPosY);
        paneRoot.getChildren().add(imgViewBotiquin);
        
        imgViewArma.setX(armaPosX);
        imgViewArma.setY(armaPosY);
        paneRoot.getChildren().add(imgViewArma);
        // Deteccion de colision de los rectangulos
        //Shape zonaColision = Shape.intersect(rectSoldados);
        
        //Posicion del soldado Derecha
        imgViewSoldadoIzquierda.setY(soldadoPosY);
        imgViewSoldadoIzquierda.setX(soldadoPosX);
        paneRoot.getChildren().add(imgViewSoldadoIzquierda);
        
        //Posicion del soldado Izquierda
        imgViewSoldadoDerecha.setY(soldadoPosY);
        imgViewSoldadoDerecha.setX(soldadoPosX);
        paneRoot.getChildren().add(imgViewSoldadoDerecha);
        
        //Pulsacion de las teclas
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()) {
                case LEFT:
                    //Pulsar tecla izquierda
                    velocidadSoldado = -5;
                    imgViewSoldadoIzquierda.setImage(imagenSoldadoIzquierda);
                    //Hcer invisible imagen izquierda y visible la derecha
                    imgViewSoldadoDerecha.setVisible(false);
                    imgViewSoldadoIzquierda.setVisible(true);
                    break;
                case RIGHT:
                    imgViewSoldadoDerecha.setImage(imagenSoldadoDerecha);
                    velocidadSoldado = 5;
                    //Hacer invisible imagen derecha y visible la izquierda
                    imgViewSoldadoIzquierda.setVisible(false);
                    imgViewSoldadoDerecha.setVisible(true);
                    break;
            }
        });
        
        scene.setOnKeyReleased((KeyEvent event) -> {
            velocidadSoldado = 0;
        });

        //Rectangle soldado = new Rectangle(50, soldadoPosY, 5, 20);
        //soldado.setFill(Color.WHITE);
        //root.getChildren().add(soldado);
        Timeline movimiento_Soldado = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                //Actualizar Posicion del Soldado Izquierda
                soldadoPosX += velocidadSoldado;
                imgViewSoldadoIzquierda.setX(soldadoPosX);

                //Actualizar Posicion del Soldado Derecha
                soldadoPosX += velocidadSoldado;
                imgViewSoldadoDerecha.setX(soldadoPosX);
                                
                // Limites de imagenes del soldado
                if(soldadoPosX < 0){
                    soldadoPosX = 0;
                } else {
                    if(soldadoPosX > LARGO_ESCENA - 55) {
                        soldadoPosX = LARGO_ESCENA - 55;
                    }
                }
                
            })
        );
        movimiento_Soldado.setCycleCount(Timeline.INDEFINITE);
        movimiento_Soldado.play();
    }
    
    public static void main(String[] args) {
        launch();
    }

}