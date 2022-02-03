package es.amosrosado.proyecto_java_juego;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class App extends Application {
    
    // Variables finales
    final int ANCHO_ESCENA = 300;
    final int LARGO_ESCENA = 1000;
    final int TEXT_SIZE = 25;
    //Variables Soldadp
    int soldadoPosY = 195;
    int soldadoPosX = 195;
    int velocidadSoldado = 0;
    //Variable posicion municion
    int municionPosX = 500;
    int municionPosY = 210;
    //Variables posicion Botiquin
    int botiquinPosX = 700;
    int botiquinPosY = 220;
    //Variables Posicion Arma
    int armaPosX = 900;
    int armaPosY = 230;
    //Variables posicion bombas
    int posicionBombaX = 100;
    int posicionBomba2X = 300;
    int posicionBomba3X = 500;
    int posicionBomba4X = 700;
    
    int posicionBombaY = 10;
    int velocidadConstBomba = 2;

    int posicionBomba2Y = 10;
    int velocidadConstBomba2 = 2;
    
    int posicionBomba3Y = 10;
    int velocidadConstBomba3 = 2;

    int posicionBomba4Y = 10;
    int velocidadConstBomba4 = 2;
    
    // Variables Random 
    int randomBombaX;
    int randomBombaY;
    int randomVelocidadBomba;
    
    int puntuacion;
    
    Timeline movimiento_Soldado;
    Timeline movimiento_Bomba;
    
    ImageView imgViewSoldadoDerecha;
    ImageView imgViewSoldadoIzquierda;
    ImageView imgViewMapa;
    ImageView imgViewMunicion;
    ImageView imgViewBotiquin;
    ImageView imgViewArma;
    ImageView imgViewBomba1;
    ImageView imgViewBomba2;
    ImageView imgViewBomba3;
    ImageView imgViewBomba4;
    
    Group groupRectSoldados;
    Group groupRectMunicion;
    Group groupRectBotiquin;
    Group groupRectArma;
    Group groupRectBomba;
    Group groupRectBomba2;
    Group groupRectBomba3;
    Group groupRectBomba4;
    
    Text textoPuntuacion;
    Text textoDificultad;
//    Text textoFinPartida;
    Label textoFinPartida;
    Scene scene;
    
    //Metodo para el incremento de velocidad de la Bomba 1
    private void switchRandomBomba() {
        
        Random random = new Random();
        randomBombaX = random.nextInt(950);
        randomBombaY = random.nextInt(395); 
        randomVelocidadBomba = random.nextInt(1);
 
        switch(randomVelocidadBomba) {
            case 0:
                velocidadConstBomba = 2;
                break;
            case 1:
                velocidadConstBomba = 3;
        }
                if(puntuacion >= 10) {
            switch(randomVelocidadBomba) {
                case 0:
                    velocidadConstBomba = 3;
                    break;
                case 1:
                    velocidadConstBomba = 4;
                    break;
            } 
        }
        if(puntuacion >= 20) {
            switch(randomVelocidadBomba) {
                case 0:
                    velocidadConstBomba = 4;
                    break;
                case 1:
                    velocidadConstBomba = 5;
                    break;
            } 
        }
                if(puntuacion >= 30) {
            switch(randomVelocidadBomba) {
                case 0:
                    velocidadConstBomba = 6;
                    break;
                case 1:
                    velocidadConstBomba = 7;
                    break;
            } 
        }
    }
    
    //Metodo para el incremento de la velocidad de la Bomba 2
    private void switchRandomBomba2() {
        
        Random random = new Random();
        randomBombaX = random.nextInt(950);
        randomBombaY = random.nextInt(395); 
        randomVelocidadBomba = random.nextInt(2);
 
        switch(randomVelocidadBomba) {
            case 0:
                velocidadConstBomba2 = 2;
                break;
            case 1:
                velocidadConstBomba2 = 3;
                break;
        }
        if(puntuacion >= 10) {
            switch(randomVelocidadBomba) {
                case 0:
                    velocidadConstBomba2 = 3;
                    break;
                case 1:
                    velocidadConstBomba2 = 4;
                    break;
            } 
        }
        if(puntuacion >= 20) {
            switch(randomVelocidadBomba) {
                case 0:
                    velocidadConstBomba2 = 4;
                    break;
                case 1:
                    velocidadConstBomba2 = 5;
                    break;
            } 
        }
        if(puntuacion >= 30) {
            switch(randomVelocidadBomba) {
                case 0:
                    velocidadConstBomba2 = 6;
                    break;
                case 1:
                    velocidadConstBomba2 = 7;
                    break;
            } 
        }
    }
    
    //Metodo para el incremento de la velocidad de la Bomba 3
    private void switchRandomBomba3() {
        
        Random random = new Random();
        randomBombaX = random.nextInt(950);
        randomBombaY = random.nextInt(395); 
        randomVelocidadBomba = random.nextInt(1);
 
        switch(randomVelocidadBomba) {
            case 0:
                velocidadConstBomba3 = 2;
                break;
            case 1:
                velocidadConstBomba3 = 3;
                break;
        }
                if(puntuacion >= 10) {
            switch(randomVelocidadBomba) {
                case 0:
                    velocidadConstBomba3 = 3;
                    break;
                case 1:
                    velocidadConstBomba3 = 4;
                    break;
            } 
        }
        if(puntuacion >= 20) {
            switch(randomVelocidadBomba) {
                case 0:
                    velocidadConstBomba3 = 4;
                    break;
                case 1:
                    velocidadConstBomba3 = 5;
                    break;
            } 
        }
        if(puntuacion >= 30) {
            switch(randomVelocidadBomba) {
                case 0:
                    velocidadConstBomba3 = 6;
                    break;
                case 1:
                    velocidadConstBomba3 = 7;
                    break;
            } 
        }
    }
    
    //Metodo para el incremento de la velocidad de la Bomba 4
    private void switchRandomBomba4() {
        
        Random random = new Random();
        randomBombaX = random.nextInt(950);
        randomBombaY = random.nextInt(395); 
        randomVelocidadBomba = random.nextInt(4);
 
        switch(randomVelocidadBomba) {
            case 0:
                velocidadConstBomba4 = 2;
                break;
            case 1:
                velocidadConstBomba4 = 3;
                break;
        }
                if(puntuacion >= 10) {
            switch(randomVelocidadBomba) {
                case 0:
                    velocidadConstBomba4 = 3;
                    break;
                case 1:
                    velocidadConstBomba4 = 4;
                    break;
            } 
        }
        if(puntuacion >= 20) {
            switch(randomVelocidadBomba) {
                case 0:
                    velocidadConstBomba4 = 4;
                    break;
                case 1:
                    velocidadConstBomba4 = 5;
                    break;
            } 
        }
        if(puntuacion >= 30) {
            switch(randomVelocidadBomba) {
                case 0:
                    velocidadConstBomba4 = 6;
                    break;
                case 1:
                    velocidadConstBomba4 = 7;
                    break;
            } 
        }
    }
    
    //Metodo para las posiciones aleatorias de los objetivos
    private void switchRandom() {
        
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
    }
    
    //Metodo para el reinicio de partida
    private void reinicioPartida() {
        puntuacion = 0;
        textoFinPartida.setVisible(true);
        textoPuntuacion.setText(String.valueOf(puntuacion));
        textoDificultad.setText("Facil");
        movimiento_Soldado.stop();
        movimiento_Bomba.stop();
        
    }
    
    @Override
    public void start(Stage stage) {
        
        //-------------------------- CREACION ESCENA -------------------------------//
        
        Pane paneRoot = new Pane();
        scene = new Scene(paneRoot, LARGO_ESCENA, ANCHO_ESCENA);
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
        
        //Imagen Bomba1
        Image imagenBomba = new Image(getClass().getResourceAsStream("/images/Bomba.png"));
        imgViewBomba1 = new ImageView(imagenBomba);
        
        //Imagen Bomba2
        imgViewBomba2 = new ImageView(imagenBomba);
        
        //Imagen Bomba3
        imgViewBomba3 = new ImageView(imagenBomba);
        
         //Imagen Bomba4
        imgViewBomba4 = new ImageView(imagenBomba);
        
        //-------------------------- ENGLOBACIONES ---------------------------//
        
        //Englobacion de grupo imagenes soldados
        Rectangle rectSoldados = new Rectangle(50, 50);
        groupRectSoldados = new Group();
        groupRectSoldados.getChildren().addAll(rectSoldados, imgViewSoldadoIzquierda, imgViewSoldadoDerecha);
        rectSoldados.setVisible(false);
        //Posicion inicial Grupo Soldados
        groupRectSoldados.setLayoutX(195);
        groupRectSoldados.setLayoutY(210);
        paneRoot.getChildren().add(groupRectSoldados);

        //Englobacion grupo municion == 0
        Rectangle rectMunicion = new Rectangle(57,53);
        groupRectMunicion = new Group();
        groupRectMunicion.getChildren().addAll(rectMunicion, imgViewMunicion);
        rectMunicion.setVisible(false);
        //Posicion inicial Grupo Municion
        groupRectMunicion.setLayoutX(1000);
        groupRectMunicion.setLayoutY(230);
        paneRoot.getChildren().add(groupRectMunicion);
        
        //Englobacion grupo botiquin == 1
        Rectangle rectBotiquin = new Rectangle(59, 38);
        groupRectBotiquin = new Group();
        groupRectBotiquin.getChildren().addAll(rectBotiquin, imgViewBotiquin);
        rectBotiquin.setVisible(false);
        //Posicion inicial Grupo Botiquin
        groupRectBotiquin.setLayoutX(1000);
        groupRectBotiquin.setLayoutY(230);
        paneRoot.getChildren().add(groupRectBotiquin);
        
        //Englobacion grupo arma == 2
        Rectangle rectArma = new Rectangle(100, 32);
        groupRectArma = new Group();
        groupRectArma.getChildren().addAll(rectArma, imgViewArma);
        rectArma.setVisible(false);
        //Posicion inicial Grupo Arma
        groupRectArma.setLayoutX(1000);
        groupRectArma.setLayoutY(240);
        paneRoot.getChildren().add(groupRectArma);
        
        //Englobacion grupo bomba1
        Rectangle rectBomba = new Rectangle(45, 50);
        groupRectBomba = new Group();
        groupRectBomba.getChildren().addAll(rectBomba, imgViewBomba1);
        rectBomba.setVisible(false);
        //Posicion inicial Grupo Bomba1
        groupRectBomba.setLayoutX(500);
        groupRectBomba.setLayoutY(-50);
        paneRoot.getChildren().add(groupRectBomba);
        
        //Englobacion grupo bomba2
        Rectangle rectBomba2 = new Rectangle(45, 50);
        groupRectBomba2 = new Group();
        groupRectBomba2.getChildren().addAll(rectBomba2, imgViewBomba2);
        rectBomba2.setVisible(false);
        //Posicion inicial Grupo Bomba2
        groupRectBomba2.setLayoutX(100);
        groupRectBomba2.setLayoutY(-50);
        paneRoot.getChildren().add(groupRectBomba2);
        
        //Englobacion grupo bomba3
        Rectangle rectBomba3 = new Rectangle(45, 50);
        groupRectBomba3 = new Group();
        groupRectBomba3.getChildren().addAll(rectBomba3, imgViewBomba3);
        rectBomba3.setVisible(false);
        //Posicion inicial Grupo Bomba3
        groupRectBomba3.setLayoutX(700);
        groupRectBomba3.setLayoutY(-50);
        paneRoot.getChildren().add(groupRectBomba3);
        
        //Englobacion grupo bomba4
        Rectangle rectBomba4 = new Rectangle(45, 50);
        groupRectBomba4 = new Group();
        groupRectBomba4.getChildren().addAll(rectBomba4, imgViewBomba4);
        rectBomba4.setVisible(false);
        //Posicion inicial Grupo Bomba4
        groupRectBomba4.setLayoutX(300);
        groupRectBomba4.setLayoutY(-50);
        paneRoot.getChildren().add(groupRectBomba4);
        
        //Metodo para quelos objetivos aparezcan aleatoriamente
        switchRandom();
        
        //------------------------------- PUNTUACIONES ------------------------------//
        
        HBox paneScores = new HBox();
        paneScores.setTranslateY(20);
        paneScores.setMinWidth(LARGO_ESCENA);
        paneScores.setAlignment(Pos.CENTER);
        paneScores.setSpacing(300);
        paneRoot.getChildren().add(paneScores);
        
        HBox paneCurrentScore = new HBox();
        paneCurrentScore.setSpacing(10);
        paneScores.getChildren().add(paneCurrentScore);
        
        HBox finPartida = new HBox();
        finPartida.setSpacing(10);
        paneScores.getChildren().add(finPartida);
        
        HBox paneHighScore = new HBox();
        paneHighScore.setSpacing(10);
        paneScores.getChildren().add(paneHighScore);
        
        //Texto fin partida
        textoFinPartida = new Label("HAS MUERTO");
        textoFinPartida.setTextFill(Color.WHITE);
        textoFinPartida.setMinWidth(LARGO_ESCENA);
        textoFinPartida.setAlignment(Pos.CENTER);
        textoFinPartida.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0, 0.7), new CornerRadii(5.0), new Insets(-5.0))));
        paneRoot.getChildren().add(textoFinPartida);
        textoFinPartida.setFont(Font.font(70));
        textoFinPartida.setVisible(false);
        
        //Texto del titulo de la puntuacion
        Text textoTituloPuntuacion = new Text("Puntuacion:");
        textoTituloPuntuacion.setFont(Font.font(TEXT_SIZE));
        textoTituloPuntuacion.setFill(Color.WHITE);
        
        //Texto de la puntuacion
        textoPuntuacion = new Text("0");
        textoPuntuacion.setFont(Font.font(TEXT_SIZE));
        textoPuntuacion.setFill(Color.WHITE);
        
        //Texto del titulo de la dificultad
        Text textoTituloDificultad = new Text("Dificultad:");
        textoTituloDificultad.setFont(Font.font(TEXT_SIZE));
        textoTituloDificultad.setFill(Color.BLACK);
        
        //Texto de la dificultad
        textoDificultad = new Text("Facil");
        textoDificultad.setFont(Font.font(TEXT_SIZE));
        textoDificultad.setFill(Color.BLACK);
        
        paneCurrentScore.getChildren().add(textoTituloPuntuacion);
        paneCurrentScore.getChildren().add(textoPuntuacion);
        paneHighScore.getChildren().add(textoTituloDificultad);
        paneHighScore.getChildren().add(textoDificultad);
//        finPartida.getChildren().add(textoFinPartida);
        
        //------------------- PULSACION DE TECLAS --------------------------//
        
        //Pulsacion de las teclas
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()) {
                case LEFT:
                    //Pulsar tecla izquierda
                    velocidadSoldado = -3;
                    imgViewSoldadoIzquierda.setImage(imagenSoldadoIzquierda);
                    //Hacer invisible imagen izquierda y visible la derecha
                    imgViewSoldadoDerecha.setVisible(false);
                    imgViewSoldadoIzquierda.setVisible(true);
                    break;
                case RIGHT:
                    //Pulsar tecla derecha
                    imgViewSoldadoDerecha.setImage(imagenSoldadoDerecha);
                    velocidadSoldado = 3;
                    //Hacer invisible imagen derecha y visible la izquierda
                    imgViewSoldadoIzquierda.setVisible(false);
                    imgViewSoldadoDerecha.setVisible(true);
                    break;
                case SPACE:
                    //Pulsar el espacio
                    //Timeline se cambia a play
                    movimiento_Soldado.play();
                    movimiento_Bomba.play();
                    //Poner los objetivos a 0
                    puntuacion = 0;
                    textoPuntuacion.setText("0");
                    //Actualizar posicion del Soldado
                    soldadoPosX = 195;
                    //Quitar el texto "has muerto"
                    textoFinPartida.setVisible(false);
                    textoFinPartida.setText("HAS MUERTO");
                    //Actualizar texto de la dificultad
                    textoDificultad.setText("Facil");
                    //Actualizar posiciones bombas en X
                    posicionBombaX = 100;;
                    posicionBomba2X = 300;
                    posicionBomba3X = 500;
                    posicionBomba4X = 700;
                    //Actualizar posiciones bombas en Y
                    posicionBombaY = -50;
                    posicionBomba2Y = -50;
                    posicionBomba3Y = -50;
                    posicionBomba4Y = -50;
            }
        });
        
        scene.setOnKeyReleased((KeyEvent event) -> {
            velocidadSoldado = 0;
        });

    //-------------------------- TIMELINE SOLDADO --------------------------------------//
    
            movimiento_Soldado = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                //Actualizar Posicion del Soldado Izquierda
                soldadoPosX += velocidadSoldado;
                groupRectSoldados.setLayoutX(soldadoPosX);

                //Actualizar Posicion del Soldado Derecha
                soldadoPosX += velocidadSoldado;
                groupRectSoldados.setLayoutX(soldadoPosX);
                                
                // Limites del soldado
                if(soldadoPosX < 0){
                    soldadoPosX = 0;
                } else {
                    if(soldadoPosX > LARGO_ESCENA - 55) {
                        soldadoPosX = LARGO_ESCENA - 55;
                    }
                }
                
                //Actualiza el texto de la dificultad al llegar a los objetivos
                if(puntuacion == 10) {
                    textoDificultad.setText("Media");
                }
                if(puntuacion == 20) {
                    textoDificultad.setText("Dificil");
                }
                if(puntuacion == 30) {
                    textoDificultad.setText("INSANO");
                }
                if(puntuacion >= 35) {
                    textoFinPartida.setVisible(true);
                    puntuacion = 0;
                    textoFinPartida.setText("YOU WIN!");
                    movimiento_Soldado.stop();
                    movimiento_Bomba.stop();
                }
                
        //---------------------------------- COLISIONES ---------------------------------------------//
        
                Shape colisionSoldadoMunicion = Shape.intersect(rectSoldados, rectMunicion);
                boolean colisionMunicion = colisionSoldadoMunicion.getBoundsInLocal().isEmpty();
                if(colisionMunicion == false) {
                    groupRectMunicion.setLayoutX(1200);
                    switchRandom();
                    //Incrementamos la puntuacion
                    puntuacion++;
                    textoPuntuacion.setText(String.valueOf(puntuacion));
                }
                Shape colisionSoldadoBotiquin = Shape.intersect(rectSoldados, rectBotiquin);
                boolean colisionBotiquin = colisionSoldadoBotiquin.getBoundsInLocal().isEmpty();
                if(colisionBotiquin == false) {
                    groupRectBotiquin.setLayoutX(1200); 
                    switchRandom();
                    //Incrementamos la puntuacion
                    puntuacion++;
                    textoPuntuacion.setText(String.valueOf(puntuacion));
                }
                    
                Shape colisionSoldadoArma = Shape.intersect(rectSoldados, rectArma);
                boolean colisionArma = colisionSoldadoArma.getBoundsInLocal().isEmpty();
                if(colisionArma == false) {
                    groupRectArma.setLayoutX(1200);
                    switchRandom();
                    //Incrementamos la puntuacion
                    puntuacion++;
                    textoPuntuacion.setText(String.valueOf(puntuacion));
                }
                
                Shape colisionBomba1Soldado = Shape.intersect(rectSoldados, rectBomba);
                boolean colisionBomba = colisionBomba1Soldado.getBoundsInLocal().isEmpty();
                if(colisionBomba == false) {
                    reinicioPartida();
                }
                
                Shape colisionBomba2Soldado = Shape.intersect(rectSoldados, rectBomba2);
                boolean colisionBomba2 = colisionBomba2Soldado.getBoundsInLocal().isEmpty();
                if(colisionBomba2 == false) {
                    reinicioPartida();
                }
                
                Shape colisionBomba3Soldado = Shape.intersect(rectSoldados, rectBomba3);
                boolean colisionBomba3 = colisionBomba3Soldado.getBoundsInLocal().isEmpty();
                if(colisionBomba3 == false) {
                    reinicioPartida();
                }
                
                Shape colisionBomba4Soldado = Shape.intersect(rectSoldados, rectBomba4);
                boolean colisionBomba4 = colisionBomba4Soldado.getBoundsInLocal().isEmpty();
                if(colisionBomba4 == false) {
                    reinicioPartida();
                }
            })
        );
            
        movimiento_Soldado.setCycleCount(Timeline.INDEFINITE);
        movimiento_Soldado.play();
        
        //---------------------- TIMELINE BOMBAS-------------------------------//
        
            movimiento_Bomba = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
        
        // --------------------- VELOCIDADES BOMBAS -------------------------//
        
                groupRectBomba.setLayoutY(posicionBombaY);
                groupRectBomba.setLayoutX(posicionBombaX);
                posicionBombaY += velocidadConstBomba;
                
//                groupRectBomba2.setLayoutY(posicionBomba2Y);
//                groupRectBomba2.setLayoutX(posicionBomba2X);
//                posicionBomba2Y += velocidadConstBomba2;
//                
//                groupRectBomba3.setLayoutY(posicionBomba3Y);
//                groupRectBomba3.setLayoutX(posicionBomba3X);
//                posicionBomba3Y += velocidadConstBomba3;
//                
//                groupRectBomba4.setLayoutY(posicionBomba4Y);
//                groupRectBomba4.setLayoutX(posicionBomba4X);
//                posicionBomba4Y += velocidadConstBomba4;

        //----------------------- ALEATORIEDAD BOMBAS -------------------------//
        
                if(posicionBombaY >= 250) {
                    posicionBombaY = -20;
                    switchRandomBomba();
                    posicionBombaX = randomBombaX;
                }
                if(posicionBomba2Y >= 250) {
                    posicionBomba2Y = -20;
                    switchRandomBomba2();
                    posicionBomba2X = randomBombaX;
                }
                if(posicionBomba3Y >= 250) {
                    posicionBomba3Y = -20;
                    switchRandomBomba3();
                    posicionBomba3X = randomBombaX;
                }
                if(posicionBomba4Y >= 250) {
                    posicionBomba4Y = -20;
                    switchRandomBomba4();
                    posicionBomba4X = randomBombaX;
                }
                           
            })
         );
        
        movimiento_Bomba.setCycleCount(Timeline.INDEFINITE);
        movimiento_Bomba.play();         
    }
    

    public static void main(String[] args) {
        launch();
    }

}