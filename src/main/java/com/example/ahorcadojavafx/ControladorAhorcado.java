package com.example.ahorcadojavafx;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControladorAhorcado {

    // VARIABLES
    public String palabraSecreta = "siranush";
    public int intentosMax = 6;
    public int intento = 0;
    public char[] letrasAdivinadas;
    public boolean adivinado = false;


    @FXML
    private Button btnEnviar;

    @FXML
    private Button btnReiniciar;

    @FXML
    private TextField letraOBT;

    @FXML
    private TextField mostrarPalabra;

    @FXML
    private ImageView vistaImagen;

    @FXML
    private TextArea letrasIntroducidas;

    @FXML
    private Label intentos;

    // INICIALIZE

    @FXML
    public void initialize() {
        // Inicializar letrasAdivinadas y mostrar al usuario
        letrasAdivinadas = new char[ palabraSecreta.length() ];

        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[ i ] = '=';
        }

        mostrarPalabra.setText(String.valueOf(letrasAdivinadas));
        intentos.setText(String.valueOf(intento));
    }


    @FXML
    void comprobarLetra(MouseEvent event) {

        if (intento < intentosMax) {

        // Manejar entrada de datos
        if (letraOBT.getText().isEmpty() || letraOBT.getText().length() > 1) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Entrada no válida");
            alert.setHeaderText("Por favor, introduce solo una letra.");
            alert.show();

            letraOBT.setText("");
            return;
        }

        // Mostramos en el textArea lo obtenido del vector de chars
        mostrarPalabra.setText(String.valueOf(letrasAdivinadas));

        //Obtenemos la letra introducida del usuario
        char letra = letraOBT.getText().toLowerCase().charAt(0);

        // Booleano para poder verificar si se ha acertado
        boolean letraCorrecta = false;

        // Recorremos el bucle buscando la letra introducida por el usuario
        for (int i = 0; i < palabraSecreta.length(); i++) {

            // ACIERTO
            if (palabraSecreta.charAt(i) == letra) {
                letrasAdivinadas[ i ] = letra;

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Has acertado!!");
                alert.setHeaderText("Has adivinado la letra "+ letra);
                alert.setContentText("Enhorabuena!");
                alert.show();

                letraCorrecta = true;

            }
        }

        // NO ACIERTO
        if (!letraCorrecta) {
            intento++;

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Letra incorrecta!!");
            alert.setHeaderText("La palabra secreta no contiene la "+ letra);
            alert.setContentText("Lastima!");
            alert.show();

            intentos.setText(String.valueOf(intento));

            switch (intento){

                case 1:
                    vistaImagen.setImage(new Image("file:src/main/estilos/1.png"));
                    break;

                case 2:
                    vistaImagen.setImage(new Image("file:src/main/estilos/2.png"));
                    break;
                case 3:
                    vistaImagen.setImage(new Image("file:src/main/estilos/3.png"));
                    break;
                case 4:
                    vistaImagen.setImage(new Image("file:src/main/estilos/4.png"));
                    break;
                case 5:
                    vistaImagen.setImage(new Image("file:src/main/estilos/5.png"));
                    break;
                case 6:
                    vistaImagen.setImage(new Image("file:src/main/estilos/6.png"));
                    break;


            }
        }

        }else{

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No tienes mas intentos, reinicia el juego!!");
            alert.setHeaderText("Reinicia el juego!");
            alert.setContentText("Lastima!");
            alert.show();
        }

        // Volvemos a mostrarlo
        mostrarPalabra.setText(String.valueOf(letrasAdivinadas));

        // También lo añado en letras en el TextArea letrasIntroducidas
        letrasIntroducidas.setText(letrasIntroducidas.getText() + letraOBT.getText().toUpperCase());

        letraOBT.clear(); // Es lo mismo que letraOBT.setText("")




        // Verificamos si ha ganado o perdido
        if (palabraSecreta.equals(mostrarPalabra.getText())) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Has ganado!!");
            alert.setHeaderText("Ganador!!!");
            alert.setContentText("Haga click en reiniciar para seguir jugando!");
            alert.show();

            vistaImagen.setImage(new Image("file:src/main/estilos/Ver fotos recientes.jpeg"));

        }

    }


    @FXML
    void reiniciarJuego(MouseEvent event) {

        palabraSecreta = "paco"; // O podrías cambiar la palabra aquí si lo deseas
        intento = 0;
        adivinado = false;
        letrasAdivinadas = new char[ palabraSecreta.length() ];
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[ i ] = '=';
        }
        mostrarPalabra.setText(String.valueOf(letrasAdivinadas));
        intentos.setText(String.valueOf(intento));
        letrasIntroducidas.setText("");
    }

}
