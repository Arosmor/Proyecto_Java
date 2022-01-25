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
import javafx.scene.shape.Shape;
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
        
        // ------------------------------- IMAGENES --------------------------------//
        
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
                
        //Imagen Municion
        Image imagenMunicion = new Image(getClass().getResourceAsStream("/images/Municion.png"));
        imgViewMunicion = new ImageView(imagenMunicion);
        
        //ImagenBotiquin
        Image imagenBotiquin = new Image(getClass().getResourceAsStream("/images/Botiquin.png"));
        imgViewBotiquin = new ImageView(imagenBotiquin);
        
        //Imagen Arma
        Image imagenArma = new Image(getClass().getResourceAsStream("/images/Arma.png"));
        imgViewArma = new ImageView(imagenArma);
        
        //-------------------------- ENGLOBACIONES ---------------------------//
        
        //Englobacion para colisiones imagenes soldados
        Rectangle rectSoldados = new Rectangle(70, 70);
        Group groupRectSoldados = new Group();
        groupRectSoldados.getChildren().addAll(rectSoldados, imgViewSoldadoIzquierda, imgViewSoldadoDerecha);
        rectSoldados.setVisible(false);
        //Posicion inicial Grupo Soldados
        groupRectSoldados.setLayoutX(195);
        groupRectSoldados.setLayoutY(195);
        paneRoot.getChildren().add(groupRectSoldados);

        //Englobacion imagen municion == 0
        Rectangle rectMunicion = new Rectangle(57,53);
        Group groupRectMunicion = new Group();
        groupRectMunicion.getChildren().addAll(rectMunicion, imgViewMunicion);
        rectMunicion.setVisible(false);
        //Posicion inicial Grupo Municion
        groupRectMunicion.setLayoutX(1000);
        groupRectMunicion.setLayoutY(230);
        paneRoot.getChildren().add(groupRectMunicion);
        
        //Englobacion imagen botiquin == 1
        Rectangle rectBotiquin = new Rectangle(59, 38);
        Group groupRectBotiquin = new Group();
        groupRectBotiquin.getChildren().addAll(rectBotiquin, imgViewBotiquin);
        rectBotiquin.setVisible(false);
        //Posicion inicial Grupo Botiquin
        groupRectBotiquin.setLayoutX(1000);
        groupRectBotiquin.setLayoutY(230);
        paneRoot.getChildren().add(groupRectBotiquin);
        
        //Englobacion imagen arma == 2
        Rectangle rectArma = new Rectangle(100, 32);
        Group groupRectArma = new Group();
        groupRectArma.getChildren().addAll(rectArma, imgViewArma);
        rectArma.setVisible(false);
        //Posicion inicial Grupo Arma
        groupRectArma.setLayoutX(1000);
        groupRectArma.setLayoutY(240);
        paneRoot.getChildren().add(groupRectArma);
        
        //---------------------- COLISIONES ------------------------------//
        
        Shape colisionSoldadoMunicion = Shape.intersect(rectSoldados, rectMunicion);
        Shape colisionesSoldadoBotiquin = Shape.intersect(rectBotiquin, rectBotiquin);
        Shape colisionSoldadoArma = Shape.intersect(rectBotiquin, rectArma);
        
        //----------------- POSICIONES ALEATORIAS ----------------------//
        
        //Eleccion aleatoria de objetivos
        Random objetivoRandom = new Random();
        int objetivoAleatorio = objetivoRandom.nextInt(3);
        
        //Posicion aleatoria de Ojbetivos
        Random posicionRandom = new Random();
        int posicionAleatoria = posicionRandom.nextInt(900);
        
        //----------------------- CONDICION ---------------------------//
        
        switch(objetivoAleatorio) {
            case 0:
                groupRectMunicion.setLayoutX(posicionAleatoria);
                break;
            case 1:
                groupRectBotiquin.setLayoutX(posicionAleatoria);
                break;
            case 2:
                groupRectArma.setLayoutX(posicionAleatoria);
                break;
        }
        
        //------------------- PULSACION DE TECLAS --------------------------//
        
        //Pulsacion de las teclas
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()) {
                case LEFT:
                    //Pulsar tecla izquierda
                    velocidadSoldado = -5;
                    imgViewSoldadoIzquierda.setImage(imagenSoldadoIzquierda);
                    //Hacer invisible imagen izquierda y visible la derecha
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
                groupRectSoldados.setLayoutX(soldadoPosX);

                //Actualizar Posicion del Soldado Derecha
                soldadoPosX += velocidadSoldado;
                groupRectSoldados.setLayoutX(soldadoPosX);
                                
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