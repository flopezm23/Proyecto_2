package com.example.proyecto2_2022;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import  com.itextpdf.text.pdf.PdfWriter;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HelloController extends Document {
    @FXML
    private Label welcomeText;

    @FXML
    Button btActivar;
    @FXML
    Button btClonar;
    @FXML
    Button btEvaluar;
    @FXML
    Button btTop3;
    @FXML
    Button btAgregar;
    @FXML
    Pane pnCuestionario;
    @FXML
    Pane pnNuevo;
    @FXML
    Pane pnDetalle;
    @FXML
    Pane pnAgregar;
    @FXML
    Pane pnIngresar;
    @FXML
    Circle crAgregar;
    @FXML
    Button btCancelar;
    @FXML
    Button btSiguiente;
    //declaraciones para el cuestionario
    @FXML
    TextField txTitulo;
    @FXML
    TextField txDescripcion;
    //declaracion para la pregunta
    @FXML
    CheckBox chRespuesta1;
    @FXML
    CheckBox chRespuesta2;
    @FXML
    CheckBox chRespuesta3;
    @FXML
    CheckBox chRespuesta4;
    @FXML
    Label laDescripcion;
    @FXML
    Label laTitulo;
    @FXML
    Button btAgregarPregunta;
    @FXML
    Button btaddPregunta;
    //adicionar elementos de la pregunta
    @FXML
    TextField txaddTiempo;
    @FXML
    TextField txaddPregunta;
    @FXML
    TextField txaddPuntos;
    @FXML
    TextField txRespuesta1;
    @FXML
    TextField txRespuesta2;
    @FXML
    TextField txRespuesta3;
    @FXML
    TextField txRespuesta4;
    //para mostrar las preguntas
    @FXML
    TableView tvPreguntas;
    @FXML
    TableColumn tcPregunta;
    @FXML
    TableColumn tcTiempo;
    @FXML
    TableColumn tcPunteo;
    //para mostrar los cuestionarios
    @FXML
    TableView tvCuestionarios;
    @FXML
    TableColumn tcPin;
    @FXML
    TableColumn tcNombre;
    @FXML
    TableColumn tcDescripcion;
    //para modificar una pregunta
    @FXML
    Pane pnModificar;
    @FXML
    Button btModificar;
    @FXML
    TextField txlookPregunta;
    @FXML
    TextField txaddTiempo1;
    @FXML
    TextField txaddnPregunta;
    @FXML
    TextField txaddPuntos1;
    @FXML
    TextField txRespuesta11;
    @FXML
    TextField txRespuesta21;
    @FXML
    TextField txRespuesta31;
    @FXML
    TextField txRespuesta41;
    @FXML
    Button btModificando;
    @FXML
    Button btBuscar;
    @FXML
    Button btBorrar;
    @FXML
    CheckBox chRespuesta11;
    @FXML
    CheckBox chRespuesta21;
    @FXML
    CheckBox chRespuesta31;
    @FXML
    CheckBox chRespuesta41;
    //para activar un cuestionario
    @FXML
            Pane pnActivar;
    @FXML
            TextField flActivar;
    @FXML
            Button btActivando;
    //para borrar una pregunta
    @FXML
    Pane pnBorrar;
    @FXML
            TextField flBorrar;
    @FXML
            Button btBorrando;
    //Para Evaluar
    @FXML
            Pane pnEvaluar;
    @FXML
    Button btContinuando;
    @FXML
            TextField flPin;
    @FXML
            TextField flSobrenombre;
    @FXML
            Button btIngresar;
    @FXML
            Label txTituloEvaluar;
    @FXML
            Label txPreguntaEvaluar;
    @FXML
            CheckBox chRespondiendo1;
    @FXML
    CheckBox chRespondiendo2;
    @FXML
    CheckBox chRespondiendo3;
    @FXML
    CheckBox chRespondiendo4;
    @FXML
            Label lbPuntuacion;
    @FXML
    Label lbResultado;
    @FXML
            Button btHome;
    //PARA CLONAR EL CUESTIONARIO
    @FXML
            TextField flClonar;
    @FXML
            Pane pnClonar;
    @FXML
            Button btClonando;



    //arreglos para almacenar preguntas y cuestionarios
    Cuestionario [] pesquisa= new Cuestionario[10];
    Pregunta [] pergunta = new Pregunta[10];
    Evaluaciones[] avaliacao=new Evaluaciones[10];
    Pregunta[] perguntalimpa = new Pregunta[10];//variable para mostrar eliminar preguntas borradas
    int contador=0;//variable para agregar las preguntas
    int totalpreguntas=0;//variable para saber el total de las preguntas

//variable para identificar a que cuestionario pertenece cada pregunta
int identificador=-1;

public void homepage (ActionEvent actionEvent){//acciones de la página inicial
    if(actionEvent.getSource() == btAgregar){//este sirve para identificar el elemento que provoco este metodo
        pnNuevo.toFront();//poner este elemento al centro o mostrarlo
    }//fin del if
    if (actionEvent.getSource()==btCancelar){
        pnCuestionario.toFront();
    }//fin del if

    if(actionEvent.getSource()==btActivar){ //para llevarnos al Pane correcto
        pnActivar.toFront();
    }

    if(actionEvent.getSource()==btEvaluar){ // pra ir ao Panel Evaluar
        pnIngresar.toFront();
    }

    if(actionEvent.getSource()==btHome){//para ir a la pagina home
        pnCuestionario.toFront();
    }
    if (actionEvent.getSource()==btClonar){//para ir la pagina de clonar
        pnClonar.toFront();
    }

}// final de homepage

//agregar un cuestionario para luego agregar una pregunta
int totalcuestionario=0;//variable contadora de los cuestionarios
public void agregarCuestionario (ActionEvent actionEvent){
    ObservableList<Cuestionario> listado = FXCollections.observableArrayList(pesquisa);//para cargar los cuestionarios en la pagina inicial
    tvCuestionarios.setItems(listado);


    //para agregar cuestionario
    if(actionEvent.getSource()==btSiguiente) {
        identificador++;//suma del identificador para cada Cuestionario
        contador=0;//este contador vale cero cuando se agrega un nuevo cuestionario
        String titulo = txTitulo.getText();
        String descripcion = txDescripcion.getText();
        Cuestionario p = new Cuestionario(identificador,identificador,titulo,descripcion,"REGISTRADO");
        pesquisa[identificador]=p;
        pnDetalle.toFront();
        totalcuestionario++;//sumar cada vez que se agrega un cuestionario
        laDescripcion.setText(descripcion);
        laTitulo.setText(titulo);
    }//final del if de Siguiente

    //para agregar una pregunta
    if(actionEvent.getSource()==btaddPregunta){//if para continuar a la siguente pagina
        //ObservableList<Pregunta> listad = FXCollections.observableArrayList(pergunta);
        //tvPreguntas.setItems(listad);
        txaddPregunta.setText("");
        txaddPuntos.setText("");
        txaddTiempo.setText("");
        txRespuesta1.setText("");
        txRespuesta2.setText("");
        txRespuesta3.setText("");
        txRespuesta4.setText("");

        pnAgregar.toFront();
    }//fin del if

    if(actionEvent.getSource()==btAgregarPregunta){//if para regresar a la pantalla de detalle despues de agregar una pregunta
        int answer=0;
        String pregunta=txaddPregunta.getText();
        int tempo=Integer.parseInt(txaddTiempo.getText());
        int punteo=Integer.parseInt(txaddPuntos.getText());
        String respuesta1= txRespuesta1.getText();
        String respuesta2= txRespuesta2.getText();
        String respuesta3= txRespuesta3.getText();
        String respuesta4= txRespuesta4.getText();

        if (chRespuesta1.isSelected()){
            answer=1;
        }
        if(chRespuesta2.isSelected()){
            answer=2;
        }
        if(chRespuesta3.isSelected()){
            answer=3;
        }
        if(chRespuesta4.isSelected()){
            answer=4;
        }

        Pregunta p = new Pregunta(pregunta,punteo,tempo,identificador,respuesta1,respuesta2,respuesta3,respuesta4,answer);
        pergunta[identificador+contador]=p;
        totalpreguntas++;


        //pnCuestionario.toFront(); // este es un boton de prueba pra regresar a la pantalla inicial
        pnDetalle.toFront();


        ObservableList<Pregunta> listad = FXCollections.observableArrayList(pergunta);//para actualizar la tabla
        tvPreguntas.setItems(listad);//para actualizar la tabla
        contador++;
    }//fin del if

    int reference=0;//variable local para identificar el objeto en el arreglo
    //para activar un cuestionario
    if (actionEvent.getSource()==btActivando){
        //int reference=0;//variable local para identificar el objeto en el arreglo
        String buscar=flActivar.getText();
        //reference=0;//inicializacion de variable
        for(int i=0;i<totalcuestionario;i++){//for para buscar la pregunta
            if (pesquisa[i].getNome().equals(buscar)){ //si la pregunta es igual
                reference=i;
            }//final if
        }//final del for
        Random sx = new Random();
        int pin = sx.nextInt((1000000 - 99999) + 1) + 99999;
        int idf= pesquisa[reference].getIdentificador();
        String tema=pesquisa[reference].getNome();
        String description=pesquisa[reference].getDescripcion();
        Cuestionario pl = new Cuestionario(pin,idf,tema,description,"ACTIVADO");
        pesquisa[reference]=pl;

        ObservableList<Cuestionario> listadoss = FXCollections.observableArrayList(pesquisa);
        tvCuestionarios.setItems(listadoss);


        pnCuestionario.toFront();
    }//fin del iff Activando

    //para clonar un cuestionario
    if(actionEvent.getSource()==btClonando){ ///cambiar para clonando
        int ponto=0;//variable local para identificar el objeto en el arreglo por el pin
        int pesquisarpin= Integer.parseInt(flClonar.getText());//variable para reconocer el identificador
        int pesquisaridentificador=0;
        //reference=0;//inicializacion de variable
        for(int i=0;i<totalcuestionario;i++){//for para buscar la pregunta
            if (pesquisa[i].getPin()==pesquisarpin){ //si la pregunta es igual
                ponto=i;
                pesquisaridentificador=pesquisa[i].getIdentificador();
            }//final if
        }//final del for
        //para clonar el cuestionario sin pin y con status registrado
        identificador++;
        totalcuestionario++;
        Cuestionario siu=new Cuestionario(0,identificador,pesquisa[ponto].getNome(),pesquisa[ponto].getDescripcion(),"REGISTRADO");
        pesquisa[totalcuestionario-1]=siu;

        //para clocar las preguntas
        int sustituir=totalpreguntas;
        for (int sim=0;sim<(sustituir);sim++){
            if(pergunta[sim].getIdentificator()==pesquisaridentificador){
                totalpreguntas++; //si coincide nuestro total de preguntas aumenta
                Pregunta addsiuu=new Pregunta(pergunta[sim].getPergunta(),pergunta[sim].getPunteo(),pergunta[sim].getTempo(),identificador,pergunta[sim].getRespuesta1(),pergunta[sim].getRespuesta2(),pergunta[sim].getRespuesta3(),pergunta[sim].getRespuesta4(),pergunta[sim].getAnswer());
                pergunta[totalpreguntas-1]=addsiuu;//agregar nueva pregunta
            }//fin if

        }//fin for
        ObservableList<Cuestionario> list = FXCollections.observableArrayList(pesquisa);
        tvCuestionarios.setItems(list);
        pnCuestionario.toFront();
    }//final if de clonando


}//final de agregarCuestionario
    int reference=0;//variable local para identificar el espacio para modificar preguntas
    int referencia=0;//variable local para identificar la pregunta para el borrador
    public void  modificarPreguntas(ActionEvent actionEvent){
        //modificar una pregunta

        if(actionEvent.getSource()==btModificar){
        pnModificar.toFront();
        }//fin del if
        if (actionEvent.getSource()==btBorrar){// if para ir al Pane Borrar
            pnBorrar.toFront();
        }//final if

        if(actionEvent.getSource()==btBuscar){// TESTE PARA SABER SI EL TEXTO ACTIVA SOLITO LA ACCION
            String buscar=txlookPregunta.getText();
            //reference=0;//inicializacion de variable
            for(int i=0;i<totalpreguntas;i++){//for para buscar la pregunta
                if (pergunta[i].getPergunta().equals(buscar)){ //si la pregunta es igual
                    reference=i;
                }//final if
            }//final del for
            //mostrar la informacion de la pregunta anterior
            txaddPregunta.setText(pergunta[reference].getPergunta());
            txaddTiempo1.setText(String.valueOf(pergunta[reference].getTempo()));//convertir el entero a texto
            txaddPuntos1.setText(String.valueOf(pergunta[reference].getPunteo()));
            txRespuesta11.setText(pergunta[reference].getRespuesta1());
            txRespuesta21.setText(pergunta[reference].getRespuesta2());
            txRespuesta31.setText(pergunta[reference].getRespuesta3());
            txRespuesta41.setText(pergunta[reference].getRespuesta4());
        }//final del if

        if(actionEvent.getSource()==btModificando){//guardar los nuevos valores
            int answer=0;
            String pregunta=txaddnPregunta.getText();
            int tempo=Integer.parseInt(txaddTiempo1.getText());
            int punteo=Integer.parseInt(txaddPuntos1.getText());
            String respuesta1= txRespuesta11.getText();
            String respuesta2= txRespuesta21.getText();
            String respuesta3= txRespuesta31.getText();
            String respuesta4= txRespuesta41.getText();
            int identificator=pergunta[reference].getIdentificator();

            if (chRespuesta11.isSelected()){
                answer=1;
            }
            if(chRespuesta21.isSelected()){
                answer=2;
            }
            if(chRespuesta31.isSelected()){
                answer=3;
            }
            if(chRespuesta41.isSelected()){
                answer=4;
            }

            Pregunta p = new Pregunta(pregunta,punteo,tempo,identificator,respuesta1,respuesta2,respuesta3,respuesta4,answer);
            pergunta[reference]=p;
            ObservableList<Pregunta> listad = FXCollections.observableArrayList(pergunta);//para actualizar la tabla
            tvPreguntas.setItems(listad);//para actualizar la tabla
            pnDetalle.toFront();
        }//fin del if


        if(actionEvent.getSource()==btBorrando){  //para borrar
            int nuevapregunta=0;

            String buscandos=flBorrar.getText();
            for(int i=0;i<totalpreguntas;i++){//for para buscar la pregunta
                if (pergunta[i].getPergunta().equals(buscandos)){ //si la pregunta es igual
                    referencia=i;
                }//final if
            }//final del for

            for(int i=0;i<(totalpreguntas-1);i++) {//for para guardar el nuevo arreglo
                if (pergunta[i].getPergunta().equals(pergunta[referencia].getPergunta())){
                    String accion="";

                } else {
                    String pregunta=pergunta[i].getPergunta();
                    int tempo=pergunta[i].getTempo();
                    int punteo=pergunta[i].getPunteo();
                    String respuesta1= pergunta[i].getRespuesta1();
                    String respuesta2= pergunta[i].getRespuesta2();
                    String respuesta3= pergunta[i].getRespuesta3();
                    String respuesta4= pergunta[i].getRespuesta4();
                    int identificator=pergunta[i].getIdentificator();

                    int answered=pergunta[i].getAnswer();
                    Pregunta place = new Pregunta(pregunta,punteo,tempo,identificator,respuesta1,respuesta2,respuesta3,respuesta4,answered);
                    perguntalimpa[nuevapregunta]=place;
                    nuevapregunta++;


                }//final del else
            }//final del for


            totalpreguntas--;//aqui ya eliminamos 1 pregunta del total

            for(int i=0;i<totalpreguntas;i++) {//for para actualizar el arreglo principal
                String preguntas=perguntalimpa[i].getPergunta();
                int tempo=perguntalimpa[i].getTempo();
                int punteo=perguntalimpa[i].getPunteo();
                String respuesta1= perguntalimpa[i].getRespuesta1();
                String respuesta2= perguntalimpa[i].getRespuesta2();
                String respuesta3= perguntalimpa[i].getRespuesta3();
                String respuesta4= perguntalimpa[i].getRespuesta4();
                int identificator=perguntalimpa[i].getIdentificator();
                int answered=perguntalimpa[i].getAnswer();
                Pregunta places = new Pregunta(preguntas,punteo,tempo,identificator,respuesta1,respuesta2,respuesta3,respuesta4,answered);
                pergunta[i]=places;


            }//fin del for

            ObservableList<Pregunta> listados = FXCollections.observableArrayList(pergunta);//para actualizar la tabla
            tvPreguntas.setItems(listados);//para actualizar la tabla

            pnDetalle.toFront();


        }//fin del if

    }//final del modificar preguntas

    int totalevaluaciones=0;
    int acontecendo=0;
    int puntuando=0;
    public void Evaluaciones(ActionEvent actionEvent){// throws InterruptedException {
        Pregunta [] apresentando = new Pregunta[10];//arreglo para saber cuales preguntas passar
        if(actionEvent.getSource()==btIngresar){//para ir al pane Evaluar
            pnEvaluar.toFront();
        }//fin iff btIngresar
        int mirespuesta=0;


        int pin=Integer.parseInt(flPin.getText());
        String sobrenombre=flSobrenombre.getText();
        int recognize=0;


        for(int j=0;j<totalcuestionario;j++){//for para encontrar el identificador a utilizar
            if(pesquisa[j].getPin()==pin){
                recognize=pesquisa[j].getIdentificador();//saber el identificador
            }//fin if
        }//final for

            int preguntaspassar=0;

        for (int f=0;f<totalpreguntas;f++){//for para mostrar pregunta
            //TimeUnit.SECONDS.sleep(pergunta[f].getTempo());//para utilizar el retraso
            if(pergunta[f].getIdentificator()==recognize){
                apresentando[preguntaspassar]=pergunta[f];//almazenar preguntas para presentar
                preguntaspassar++;
                /*
                String paramostrar=pergunta[f].getPergunta();
                txPreguntaEvaluar.setText(paramostrar);
                chRespondiendo1.setText(pergunta[f].getRespuesta1());
                chRespondiendo2.setText(pergunta[f].getRespuesta2());
                chRespondiendo3.setText(pergunta[f].getRespuesta3());
                chRespondiendo4.setText(pergunta[f].getRespuesta4());

                if(chRespondiendo1.isSelected()){
                    mirespuesta=1;
                }
                if(chRespondiendo2.isSelected()){
                    mirespuesta=2;
                }
                if(chRespondiendo3.isSelected()){
                    mirespuesta=3;
                }
                if(chRespondiendo4.isSelected()){
                    mirespuesta=4;
                }
                if(mirespuesta==pergunta[f].getAnswer()){
                    puntuando=puntuando+pergunta[f].getPunteo();
                }
                lbPuntuacion.setText(String.valueOf(puntuando));

                 */

            }//final if (prueba de saber cuantas preguntas pasar
        }//fin for

            //int acontecendo=0;
            String paramostrar="";
            if(acontecendo==0) {
                paramostrar = apresentando[acontecendo].getPergunta();
                txPreguntaEvaluar.setText(paramostrar);
                chRespondiendo1.setText(apresentando[acontecendo].getRespuesta1());
                chRespondiendo2.setText(apresentando[acontecendo].getRespuesta2());
                chRespondiendo3.setText(apresentando[acontecendo].getRespuesta3());
                chRespondiendo4.setText(apresentando[acontecendo].getRespuesta4());
            }

            if (actionEvent.getSource()==btContinuando){//para pasar las preguntas
                if(chRespondiendo1.isSelected()){
                    mirespuesta=1;
                }
                if(chRespondiendo2.isSelected()){
                    mirespuesta=2;
                }
                if(chRespondiendo3.isSelected()){
                    mirespuesta=3;
                }
                if(chRespondiendo4.isSelected()){
                    mirespuesta=4;
                }
                if(mirespuesta==apresentando[acontecendo].getAnswer()){
                    puntuando=puntuando+apresentando[acontecendo].getPunteo();
                }
                lbPuntuacion.setText(String.valueOf(puntuando));

                if(acontecendo<(preguntaspassar-1)){//if para ver
                    acontecendo++;
                }else {//se ya pasaron todas las preguntas
                        lbResultado.setText("Este es tu resultado Total");
                    pnCuestionario.toFront();
                }//final if

                paramostrar=apresentando[acontecendo].getPergunta(); //aqui era declarado el valor de esta variable
                txPreguntaEvaluar.setText(paramostrar);
                chRespondiendo1.setText(apresentando[acontecendo].getRespuesta1());
                chRespondiendo2.setText(apresentando[acontecendo].getRespuesta2());
                chRespondiendo3.setText(apresentando[acontecendo].getRespuesta3());
                chRespondiendo4.setText(apresentando[acontecendo].getRespuesta4());

            }//fin del if Continuar


            String pinmandar= String.valueOf(pin);
            Evaluaciones s = new Evaluaciones(puntuando,pinmandar,sobrenombre);
            avaliacao[totalevaluaciones]=s;
            totalevaluaciones++;



    }//final Evaluaciones

    public void top3pdf (ActionEvent actionEvent) throws FileNotFoundException, DocumentException {
        if(actionEvent.getSource()==btTop3) {
            int lastres=0;
            int posicao1=0;
            int posicao2=0;
            int posicao3=0;
            double mayor=0;
            double medio=0;
            double menor=0;
            //encontrar los 3 mejores

                for(int u=0; u<totalevaluaciones;u++){
                    if(avaliacao[u].getPunteo()>mayor){
                        mayor=avaliacao[u].getPunteo();//guardar la posicion
                        posicao1=u;
                    }//fin if
                    if(avaliacao[u].getPunteo()<mayor&&avaliacao[u].getPunteo()>medio){
                        medio=avaliacao[u].getPunteo();
                        posicao2=u;
                    }//fin if
                    if (avaliacao[u].getPunteo()<medio&&avaliacao[u].getPunteo()>menor){
                        menor=avaliacao[u].getPunteo();
                        posicao3=u;
                    }//fin if

                }//fin for

            var better3 = new HelloController();

            PdfWriter.getInstance(better3, new FileOutputStream("Top3.pdf"));
            better3.open();

            var bold = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            var topper1 = new Paragraph(avaliacao[posicao1].getNickname()+avaliacao[posicao1].getPunteo());//string de contenido para este parrafo
            var topper2 = new Paragraph(avaliacao[posicao2].getNickname()+avaliacao[posicao2].getPunteo());//string de contenido para este parrafo
            var topper3 = new Paragraph(avaliacao[posicao3].getNickname()+avaliacao[posicao3].getPunteo());//string de contenido para este parrafo

            better3.add(topper1);
            better3.add(topper2);
            better3.add(topper3);

            better3.close();
        }//fin if
    }//fin top3pdf


    public void initialize(){
    //para preguntas
        tcPregunta.setCellValueFactory(new PropertyValueFactory<Pregunta, String>("pergunta"));
        tcTiempo.setCellValueFactory(new PropertyValueFactory<Pregunta, Integer>("tempo"));
        tcPunteo.setCellValueFactory(new PropertyValueFactory<Pregunta, Integer>("punteo"));
        ObservableList<Pregunta> listad = FXCollections.observableArrayList(pergunta);
        tvPreguntas.setItems(listad);
        //para cuestionarios
        tcPin.setCellValueFactory(new PropertyValueFactory<Cuestionario, Integer>("pin"));
        tcNombre.setCellValueFactory(new PropertyValueFactory<Cuestionario, String>("nome"));
        tcDescripcion.setCellValueFactory(new PropertyValueFactory<Cuestionario, String>("descripcion"));
        ObservableList<Cuestionario> listado = FXCollections.observableArrayList(pesquisa);
        tvCuestionarios.setItems(listado);

    }//final de initialize



}