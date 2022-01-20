package es.amosrosado.proyecto_java_juego;

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
    
    ImageView imgViewSoldado;
    ImageView imgViewMapa;
    
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
        imgViewSoldado = new ImageView(imagenSoldadoDerecha);
        
        //Englobacion para colisiones
        Rectangle rectZona1 = new Rectangle(195, 195);
        Group groupZona1 = new Group();
        groupZona1.getChildren().addAll(imagenSoldadoDerecha, rectZona1);
        //Hacemos Invisible el Rectangulo
        //rectZona1.setVisible(false);
        //Imagen Soladado Izquierda
        Image imagenSoldadoIzquierda = new Image(getClass().getResourceAsStream("/images/SoldadoIzquierda.png"));
        imgViewSoldado = new ImageView(imagenSoldadoIzquierda);
        
        //Posicion del soldado
        imgViewSoldado.setY(soldadoPosY);
        imgViewSoldado.setX(soldadoPosX);
        paneRoot.getChildren().add(imgViewSoldado);
        
        //Pulsacion de las teclas
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()) {
                case LEFT:
                    //Pulsar tecla izquierda
                    velocidadSoldado = -5;
                    imgViewSoldado.setImage(imagenSoldadoIzquierda);
                    break;
                case RIGHT:
                    imgViewSoldado.setImage(imagenSoldadoDerecha);
                    velocidadSoldado = 5;
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
                //Actualizar Posicion del Soldado
                soldadoPosX += velocidadSoldado;
                imgViewSoldado.setX(soldadoPosX);
            })
        );
        movimiento_Soldado.setCycleCount(Timeline.INDEFINITE);
        movimiento_Soldado.play();
    }
    
    public static void main(String[] args) {
        launch();
    }

}