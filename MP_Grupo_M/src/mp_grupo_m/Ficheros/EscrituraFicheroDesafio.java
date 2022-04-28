package mp_grupo_m.Ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import mp_grupo_m.Entidades.*;
import mp_grupo_m.Sistema;
import mp_grupo_m.Terminal;

/**
 *
 * @author octavio
 */
public class EscrituraFicheroDesafio {

    Sistema sistema = new Sistema();
    Terminal terminal = new Terminal();
    LecturaFicheroDesafio lecturaFicheroDesafio = new LecturaFicheroDesafio();

    public void registroDesafio(Desafio desafio) throws IOException {

        try {
            String ruta = "src/mp_grupo_m/Ficheros/registroDesafio.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            //FileWriter fw = new FileWriter(file);
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true); //opción append habilitada!
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("***** DESAFIO *****");
            bw.newLine();

            ///////////DESAFIANTE ///////////
            bw.write("DESAFIANTE: ");
            bw.write(desafio.getDesafiante().getNombre());
            bw.newLine();

            bw.write("NICK: ");
            bw.write(desafio.getDesafiante().getNick());
            bw.newLine();

            bw.write("PASSWORD: ");
            bw.write(desafio.getDesafiante().getPassword());
            bw.newLine();

            bw.write("REGISTRO: ");
            bw.write(desafio.getDesafiante().getRegistro());
            bw.newLine();

            String tipoPersonajeDesafiante = desafio.getDesafiante().getPersonaje().getTipo();
            if (tipoPersonajeDesafiante == null) {
                bw.write("TIPO_PERSONAJE: null");
                bw.newLine();
            } else if (tipoPersonajeDesafiante.equals("VAMPIRO")) {
                escrituraVampiroDesafiante(desafio, bw);
            } else if (tipoPersonajeDesafiante.equals("LICANTROPO")) {
                escrituraLicantropoDesafiante(desafio, bw);
            } else if (tipoPersonajeDesafiante.equals("CAZADOR")) {
                escrituraCazadorDesafiante(desafio, bw);
            }
            /////////// FIN DESAFIANTE ///////////

/////////// CONTRINCANTE ///////////
            //escribirCliente(listaCliente);
            bw.write("CONTRINCANTE: ");
            bw.write(desafio.getContrincante().getNumber());
            bw.newLine();

            bw.write("NICK: ");
            bw.write(desafio.getContrincante().getNick());
            bw.newLine();

            bw.write("PASSWORD: ");
            bw.write(desafio.getContrincante().getPassword());
            bw.newLine();

            bw.write("REGISTRO: ");
            bw.write(desafio.getContrincante().getRegistro());
            bw.newLine();

            String tipoPersonajeContrincante = desafio.getContrincante().getPersonaje().getTipo();
            if (tipoPersonajeContrincante == null) {
                bw.write("TIPO_PERSONAJE: null");
                bw.newLine();
            } else if (tipoPersonajeContrincante.equals("VAMPIRO")) {
                escrituraVampiroContrincante(desafio, bw);
            } else if (tipoPersonajeContrincante.equals("LICANTROPO")) {
                escrituraLicantropoContrincante(desafio, bw);
            } else if (tipoPersonajeContrincante.equals("CAZADOR")) {
                escrituraCazadorContrincante(desafio, bw);
            }

            /////////// FIN CONTRINCANTE ///////////
            bw.write("ORO: ");
            bw.write(desafio.getOro());
            bw.newLine();
//MODIFICADOR
            bw.write("CANTIDAD_MODIFICADORES: ");
            bw.write(desafio.getModificadores().size());
            bw.newLine();
            for (int j = 0; j < (desafio.getModificadores().size()); j++) {
                Modificador modificador = (Modificador) desafio.getModificadores().get(j);
                bw.write("NOMBRE_MODIFICADOR:");
                bw.write(modificador.getNombre());
                bw.newLine();

                bw.write("VALOR_DEBILIDAD:");
                bw.write(modificador.getValor());
                bw.newLine();
            }
            bw.newLine();
// FIN MODIFICADOR

            bw.write("VALIDADO: ");
            if (desafio.isValidated()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();

            bw.write("FIN USUARIO");
            bw.newLine();
            bw.close();

        } catch (Exception e) {
            Sistema sistema = new Sistema();
            sistema.selector();
            e.printStackTrace();
        }
    }

    public void sobreescribirFicheroDesafio(ArrayList<Desafio> listaDesafio) throws IOException {

        try {
            String ruta = "src/mp_grupo_m/Ficheros/registroDesafio.txt";
            File file = new File(ruta);
            // Si el archivo no existe devuelve al menu de inicio para crear el usuario. 
            if (!file.exists()) {
                System.out.println("El fichero no existe.");
                System.out.println("No se permite el registro del nuevo personaje.");
                terminal.mostrarInicio();
                sistema.selector();
            }
            //FileWriter fw = new FileWriter(file);
            FileWriter fw = new FileWriter(file); //opción append habilitada!
            BufferedWriter bw = new BufferedWriter(fw);

            //recorre la lista de clientes
            for (int i = 0; i < listaDesafio.size(); i++) {

                bw.write("***** DESAFIO *****");
                bw.newLine();

                ///////////DESAFIANTE ///////////
                bw.write("DESAFIANTE: ");
                bw.write(listaDesafio.get(i).getDesafiante().getNombre());
                bw.newLine();

                bw.write("NICK_DESAFIANTE: ");
                bw.write(listaDesafio.get(i).getDesafiante().getNick());
                bw.newLine();

                bw.write("PASSWORD_DESAFIANTE: ");
                bw.write(listaDesafio.get(i).getDesafiante().getPassword());
                bw.newLine();

                bw.write("REGISTRO_DESAFIANTE: ");
                bw.write(listaDesafio.get(i).getDesafiante().getRegistro());
                bw.newLine();

                String tipoPersonajeDesafiante = listaDesafio.get(i).getDesafiante().getPersonaje().getTipo();
                if (tipoPersonajeDesafiante == null) {
                    bw.write("TIPO_PERSONAJE: null");
                    bw.newLine();
                } else if (tipoPersonajeDesafiante.equals("VAMPIRO")) {
                    escrituraVampiroDesafiante(listaDesafio.get(i), bw);
                } else if (tipoPersonajeDesafiante.equals("LICANTROPO")) {
                    escrituraLicantropoDesafiante(listaDesafio.get(i), bw);
                } else if (tipoPersonajeDesafiante.equals("CAZADOR")) {
                    escrituraCazadorDesafiante(listaDesafio.get(i), bw);
                }
                /////////// FIN DESAFIANTE ///////////

/////////// CONTRINCANTE ///////////
                //escribirCliente(listaCliente);
                bw.write("CONTRINCANTE: ");
                bw.write(listaDesafio.get(i).getContrincante().getNumber());
                bw.newLine();

                bw.write("NICK: ");
                bw.write(listaDesafio.get(i).getContrincante().getNick());
                bw.newLine();

                bw.write("PASSWORD: ");
                bw.write(listaDesafio.get(i).getContrincante().getPassword());
                bw.newLine();

                bw.write("REGISTRO: ");
                bw.write(listaDesafio.get(i).getContrincante().getRegistro());
                bw.newLine();

                String tipoPersonajeContrincante = listaDesafio.get(i).getContrincante().getPersonaje().getTipo();
                if (tipoPersonajeContrincante == null) {
                    bw.write("TIPO_PERSONAJE: null");
                    bw.newLine();
                } else if (tipoPersonajeContrincante.equals("VAMPIRO")) {
                    escrituraVampiroContrincante(listaDesafio.get(i), bw);
                } else if (tipoPersonajeContrincante.equals("LICANTROPO")) {
                    escrituraLicantropoContrincante(listaDesafio.get(i), bw);
                } else if (tipoPersonajeContrincante.equals("CAZADOR")) {
                    escrituraCazadorContrincante(listaDesafio.get(i), bw);
                }

                /////////// FIN CONTRINCANTE ///////////
                bw.write("ORO: ");
                bw.write(listaDesafio.get(i).getOro());
                bw.newLine();


//MODIFICADOR

                bw.write("MODIFICADOR: ");
                bw.write(listaDesafio.get(i).getModificadores().size());
                bw.newLine();
                for (int j = 0; j < (listaDesafio.get(i).getModificadores().size()); j++) {
                Modificador modificador = (Modificador) listaDesafio.get(i).getModificadores().get(j);
                bw.write("NOMBRE_MODIFICADOR:");
                bw.write(modificador.getNombre());
                bw.newLine();

                bw.write("VALOR_DEBILIDAD:");
                bw.write(modificador.getValor());
                bw.newLine();
            }
                bw.newLine();
// FIN MODIFICADOR                
                

                bw.write("VALIDADO: ");
                if (listaDesafio.get(i).isValidated()) {
                    bw.write("true");
                } else {
                    bw.write("false");
                }
                bw.newLine();
                
                bw.write("REGISTRO: ");
                bw.write(listaDesafio.get(i).getRegistro());
                bw.newLine();

                bw.write("FIN USUARIO");
                bw.newLine();
                bw.close();

            }
        } catch (Exception e) {
            Sistema sistema = new Sistema();
            sistema.selector();
            e.printStackTrace();
        }
    }

    private void escrituraVampiroDesafiante(Desafio desafio, BufferedWriter bw) throws IOException {

        Vampiro vampiro = (Vampiro) desafio.getDesafiante().getPersonaje();
        Disciplina disciplina = (Disciplina) vampiro.getHabilidad();

        //TIPO PERSONAJE
        bw.write("TIPO_PERSONAJE: ");
        bw.write(desafio.getDesafiante().getPersonaje().getTipo());
        bw.newLine();
        //NOMBRE PERSONAJE
        bw.write("NOMBRE_PERSONAJE: ");
        bw.write(desafio.getDesafiante().getPersonaje().getNombre());
        bw.newLine();
        //PUNTOS DE SANGRE
        bw.write("SANGRE: ");
        bw.write(vampiro.getSangre());
        bw.newLine();
        //NOMBRE DE HABILIDAD
        bw.write("NOMNRE_HABILIDAD: ");
        bw.write(disciplina.getNombre());
        bw.newLine();

        //VALOR ATAQUE
        bw.write("VALOR_ATAQUE: ");
        bw.write(disciplina.getAtaque());
        bw.newLine();

        //VALOR DEFENSA
        bw.write("VALOR_DEFENSA: ");
        bw.write(disciplina.getDefensa());
        bw.newLine();

        //COSTE HABILIDAD
        bw.write("COSATE_HABILIDAD: ");
        bw.write(disciplina.getCoste());
        bw.newLine();

        //ARMAS
        bw.write("NUMERO_ARMAS: ");
        bw.write(desafio.getDesafiante().getPersonaje().getArmas().size());
        bw.newLine();

        for (int variableArma = 0; variableArma < (desafio.getDesafiante().getPersonaje().getArmas().size()); variableArma++) {
            Arma arma = desafio.getDesafiante().getPersonaje().getArmas().get(variableArma);
            bw.write("NOMBRE_ARMA: ");
            bw.write(arma.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA: ");
            bw.write(arma.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA:");
            bw.write(arma.getModDefensa());
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA: ");
            if (arma.isSingleHand()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();

        }
        bw.newLine();

        //NUMERO DE ARMAS ACTIVAS
        bw.write("NUMERO_ARMAS_ACTIVAS: ");
        bw.write(desafio.getDesafiante().getPersonaje().getArmasActivas().size());
        bw.newLine();
        for (int variableArmaActiva = 0; variableArmaActiva < (desafio.getDesafiante().getPersonaje().getArmasActivas().size()); variableArmaActiva++) {
            Arma armaActiva = (Arma) vampiro.getArmasActivas().get(variableArmaActiva);

            bw.write("NOMBRE_ARMAS_ACTIVAS: ");
            bw.write(armaActiva.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA_ACTIVAS:");
            bw.write(armaActiva.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA_ACTIVAS: ");
            bw.write(armaActiva.getModDefensa());
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA: ");
            if (armaActiva.isSingleHand()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();
        }
        bw.newLine();

        //ARMADURAS
        //NUMERO DE ARMADURAS
        bw.write("NUMERO_ARMADURAS: ");
        bw.write(desafio.getDesafiante().getPersonaje().getArmaduras().size());
        bw.newLine();
        for (int j = 0; j < (desafio.getDesafiante().getPersonaje().getArmaduras().size()); j++) {
            Armadura armadura = (Armadura) vampiro.getArmaduras().get(j);
            bw.write("NOMBRE_ARMADURA: ");
            bw.write(armadura.getNombre());
            bw.newLine();

            bw.write("DEFENSA_ARMADURA: ");
            bw.write(armadura.getModDefensa());
            bw.newLine();

            bw.write("ATAQUE_ARMADURA: ");
            bw.write(armadura.getModAtaque());
            bw.newLine();
        }
        bw.newLine();

        //EDAD VAMPIRO
        bw.write("EDAD_VAMPIRO: ");
        bw.write(vampiro.getEdad());
        bw.newLine();

        //ESBIRROS
        //NUMERO DE ESBIRROS
        bw.write("NUMERO_ESBIRROS: ");
        bw.write(desafio.getDesafiante().getPersonaje().getEsbirros().size());
        bw.newLine();

        //ESBIRROS
        escrituraEsbirrosDesafiante(desafio, vampiro, bw);

        bw.write("FIN_USUARIO");
        bw.newLine();
    }

    private void escrituraLicantropoDesafiante(Desafio desafio, BufferedWriter bw) throws IOException {

        Licantropo licantropo = (Licantropo) desafio.getDesafiante().getPersonaje();
        Disciplina disciplina = (Disciplina) licantropo.getHabilidad();

        //TIPO PERSONAJE
        bw.write("TIPO_PERSONAJE: ");
        bw.write(desafio.getDesafiante().getPersonaje().getTipo());
        bw.newLine();
        //NOMBRE PERSONAJE
        bw.write("NOMBRE_PERSONAJE: ");
        bw.write(desafio.getDesafiante().getPersonaje().getNombre());
        bw.newLine();

        //PUNTOS DE SANGRE
        bw.write("RABIA: ");
        bw.write(licantropo.getRabia());
        bw.newLine();

        //NUMERO ARMAS
        bw.write("NUMERO_ARMAS: ");
        bw.write(desafio.getDesafiante().getPersonaje().getArmas().size());
        bw.newLine();

        for (int variableArma = 0; variableArma < (desafio.getDesafiante().getPersonaje().getArmas().size()); variableArma++) {
            Arma arma = desafio.getDesafiante().getPersonaje().getArmas().get(variableArma);
            bw.write("NOMBRE_ARMA: ");
            bw.write(arma.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA: ");
            bw.write(arma.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA: ");
            bw.write(arma.getModDefensa());
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA: ");
            if (arma.isSingleHand()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();

        }
        bw.newLine();

        //NUMERO DE ARMAS ACTIVAS
        bw.write("NUMERO_ARMAS_ACTIVAS: ");
        bw.write(desafio.getDesafiante().getPersonaje().getArmasActivas().size());
        bw.newLine();
        for (int variableArmaActiva = 0; variableArmaActiva < (desafio.getDesafiante().getPersonaje().getArmasActivas().size()); variableArmaActiva++) {
            Arma armaActiva = (Arma) licantropo.getArmasActivas().get(variableArmaActiva);

            bw.write("NOMBRE_ARMAS_ACTIVAS: ");
            bw.write(armaActiva.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA_ACTIVAS:");
            bw.write(armaActiva.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA_ACTIVAS: ");
            bw.write(armaActiva.getModDefensa());
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA: ");
            if (armaActiva.isSingleHand()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();
        }
        bw.newLine();

        //ARMADURAS
        //NUMERO DE ARMADURAS
        bw.write("NUMERO_ARMADURAS: ");
        bw.write(desafio.getDesafiante().getPersonaje().getArmaduras().size());
        bw.newLine();
        for (int j = 0; j < (desafio.getDesafiante().getPersonaje().getArmaduras().size()); j++) {
            Armadura armadura = (Armadura) licantropo.getArmaduras().get(j);
            bw.write("NOMBRE_ARMADURA: ");
            bw.write(armadura.getNombre());
            bw.newLine();

            bw.write("DEFENSA_ARMADURA: ");
            bw.write(armadura.getModDefensa());
            bw.newLine();

            bw.write("ATAQUE_ARMADURA: ");
            bw.write(armadura.getModAtaque());
            bw.newLine();
        }
        bw.newLine();

        //ARMADURA ACTIVA / EQUIPADA
        bw.write("NOMBRE_ARMADURA_ACTIVA: ");
        bw.write(desafio.getDesafiante().getPersonaje().getArmaduraActiva().getNombre());
        bw.newLine();

        //DEFENSA ARMADURA ACTIVA / EQUIPADA
        bw.write("DEFENSA_ARMADURA_ACTIVA: ");
        bw.write(desafio.getDesafiante().getPersonaje().getArmaduraActiva().getModDefensa());
        bw.newLine();

        //ATAQUE ARMADURA ACTIVA / EQUIPADA
        bw.write("ATAQUE_ARMADURA_ACTIVA: ");
        bw.write(desafio.getDesafiante().getPersonaje().getArmaduraActiva().getModAtaque());
        bw.newLine();

        //CANTIDAD ORO
        bw.write("ORO: ");
        bw.write(desafio.getDesafiante().getPersonaje().getOro());
        bw.newLine();

        //DEBLIDADES
        //NUMERO DE DEBLIDADES
        bw.write("NUMERO_DEBILIDADES: ");
        bw.write(desafio.getDesafiante().getPersonaje().getDebilidades().size());
        bw.newLine();
        for (int j = 0; j < (desafio.getDesafiante().getPersonaje().getArmaduras().size()); j++) {
            Debilidad debilidad = (Debilidad) licantropo.getDebilidades().get(j);
            bw.write("NOMBRE_DEBILIADAD: ");
            bw.write(debilidad.getNombre());
            bw.newLine();

            bw.write("VALOR_DEBILIADAD:");
            bw.write(debilidad.getValor());
            bw.newLine();
        }
        bw.newLine();

        //FORTALEZAS
        //NUMERO DE FORTALEZAS
        bw.write("NUMERO_FORTALEZAS: ");
        bw.write(desafio.getDesafiante().getPersonaje().getFortalezas().size());
        bw.newLine();
        for (int j = 0; j < (desafio.getDesafiante().getPersonaje().getArmaduras().size()); j++) {
            Fortaleza fortaleza = (Fortaleza) licantropo.getFortalezas().get(j);
            bw.write("NOMBRE_FORTALEZA:");
            bw.write(fortaleza.getNombre());
            bw.newLine();

            bw.write("VALOR_FORTALEZA:");
            bw.write(fortaleza.getValor());
            bw.newLine();
        }
        bw.newLine();

        //ESBIRROS
        //NUMERO DE ESBIRROS
        bw.write("NUMERO_ESBIRROS: ");
        bw.write(desafio.getDesafiante().getPersonaje().getEsbirros().size());
        bw.newLine();

        //ESBIRROS
        escrituraEsbirrosDesafiante(desafio, licantropo, bw);

        bw.write("FIN_USUARIO");
        bw.newLine();
    }

    private void escrituraCazadorDesafiante(Desafio desafio, BufferedWriter bw) throws IOException {

        Cazador cazador = (Cazador) desafio.getDesafiante().getPersonaje();
        Disciplina disciplina = (Disciplina) cazador.getHabilidad();

        //TIPO PERSONAJE
        bw.write("TIPO_PERSONAJE: ");
        bw.write(desafio.getDesafiante().getPersonaje().getTipo());
        bw.newLine();
        //NOMBRE PERSONAJE
        bw.write("NOMBRE_PERSONAJE: ");
        bw.write(desafio.getDesafiante().getPersonaje().getNombre());
        bw.newLine();

        //NOMBRE HABILDIAD
        bw.write("NOMBRE_HABILIDAD: ");
        bw.write(cazador.getNombre());
        bw.newLine();

        //ATAQUE HABILIDAD
        bw.write("ATAQUE_HABILIDAD: ");
        bw.write(cazador.getHabilidad().getAtaque());
        bw.newLine();

        //DEBILIDAD HABILIDAD
        bw.write("DEFENSA_HABILIDAD: ");
        bw.write(cazador.getHabilidad().getDefensa());
        bw.newLine();

        //EDAD CAZADOR
        bw.write("EDAD_CAZADOR: ");
        bw.write(cazador.getVoluntad());  //LA EDAD ES LA VOLUNTAD DEL CAZADOR
        bw.newLine();

        //ARMAS
        //NUMERO ARMAS
        bw.write("NUMERO_ARMAS: ");
        bw.write(desafio.getDesafiante().getPersonaje().getArmas().size());
        bw.newLine();

        for (int variableArma = 0; variableArma < (desafio.getDesafiante().getPersonaje().getArmas().size()); variableArma++) {
            Arma arma = desafio.getDesafiante().getPersonaje().getArmas().get(variableArma);
            bw.write("NOMBRE_ARMA:");
            bw.write(arma.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA:");
            bw.write(arma.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA:");
            bw.write(arma.getModDefensa());
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA:");
            if (arma.isSingleHand()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();

        }
        bw.newLine();

        //ARMAS ACTIVAS
        //NUMERO DE ARMAS ACTIVAS
        bw.write("NUMERO_ARMAS_ACTIVAS: ");
        bw.write(desafio.getDesafiante().getPersonaje().getArmasActivas().size());
        bw.newLine();
        for (int variableArmaActiva = 0; variableArmaActiva < (desafio.getDesafiante().getPersonaje().getArmasActivas().size()); variableArmaActiva++) {
            Arma armaActiva = (Arma) cazador.getArmasActivas().get(variableArmaActiva);

            bw.write("NOMBRE_ARMAS_ACTIVAS:");
            bw.write(armaActiva.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA_ACTIVAS:");
            bw.write(armaActiva.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA_ACTIVAS:");
            bw.write(armaActiva.getModDefensa());
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA:");
            if (armaActiva.isSingleHand()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();
        }
        bw.newLine();

        //ARMADURAS
        //NUMERO DE ARMADURAS
        bw.write("NUMERO_ARMADURAS: ");
        bw.write(desafio.getDesafiante().getPersonaje().getArmaduras().size());
        bw.newLine();
        for (int j = 0; j < (desafio.getDesafiante().getPersonaje().getArmaduras().size()); j++) {
            Armadura armadura = (Armadura) cazador.getArmaduras().get(j);
            bw.write("NOMBRE_ARMADURA:");
            bw.write(armadura.getNombre());
            bw.newLine();

            bw.write("DEFENSA_ARMADURA:");
            bw.write(armadura.getModDefensa());
            bw.newLine();

            bw.write("ATAQUE_ARMADURA:");
            bw.write(armadura.getModAtaque());
            bw.newLine();
        }
        bw.newLine();

        //ARMADURAS EQUIPADA
        bw.write("NOMBRE_ARMADURA_ACTIVA:");
        bw.write(desafio.getDesafiante().getPersonaje().getArmaduraActiva().getNombre());
        bw.newLine();

        bw.write("DEFENSA_ARMADURA_ACTIVA:");
        bw.write(desafio.getDesafiante().getPersonaje().getArmaduraActiva().getModDefensa());
        bw.newLine();

        bw.write("ATAQUE_ARMADURA_ACTIVA:");
        bw.write(desafio.getDesafiante().getPersonaje().getArmaduraActiva().getModAtaque());
        bw.newLine();

        bw.newLine();

        //CANTIDAD ORO
        bw.write("ORO: ");
        bw.write(cazador.getOro());
        bw.newLine();

        //CANTIDAD VDA
        bw.write("VIDA: ");
        bw.write(cazador.getHp());
        bw.newLine();

        //PODER
        bw.write("PODER: ");
        bw.write(cazador.getPoder());
        bw.newLine();

        //DEBILIDADES
        //NUMERO DE DEBILIDADES
        bw.write("NUMERO_DEBILIDADES: ");
        bw.write(desafio.getDesafiante().getPersonaje().getDebilidades().size());
        bw.newLine();
        for (int j = 0; j < (desafio.getDesafiante().getPersonaje().getArmaduras().size()); j++) {
            Debilidad debilidad = (Debilidad) cazador.getDebilidades().get(j);
            bw.write("NOMBRE_DEBILIDAD:");
            bw.write(debilidad.getNombre());
            bw.newLine();

            bw.write("VALOR_DEBILIDAD:");
            bw.write(debilidad.getValor());
            bw.newLine();
        }
        bw.newLine();

        //FORTALEZAS
        //NUMERO DE FORTALEZAS
        bw.write("NUMERO_FORTALEZAS: ");
        bw.write(desafio.getDesafiante().getPersonaje().getDebilidades().size());
        bw.newLine();
        for (int j = 0; j < (desafio.getDesafiante().getPersonaje().getArmaduras().size()); j++) {
            Fortaleza fortaleza = (Fortaleza) cazador.getFortalezas().get(j);
            bw.write("NOMBRE_FORTALEZA:");
            bw.write(fortaleza.getNombre());
            bw.newLine();

            bw.write("VALOR_FORTALEZA:");
            bw.write(fortaleza.getValor());
            bw.newLine();
        }
        bw.newLine();

        //ESBIRROS
        //NUMERO DE ESBIRROS
        bw.write("NUMERO_ESBIRROS: ");
        bw.write(desafio.getDesafiante().getPersonaje().getEsbirros().size());
        bw.newLine();

        escrituraEsbirrosDesafiante(desafio, cazador, bw);

        bw.write("FIN_USUARIO");
        bw.newLine();
    }

    private void escrituraEsbirrosDesafiante(Desafio desafio, Personaje personaje, BufferedWriter bw) throws IOException {
        for (int j = 0; j < (desafio.getDesafiante().getPersonaje().getEsbirros().size()); j++) {
            if (personaje.getEsbirros().get(j).getTipo().equals("HUMANO")) {
                Humano humano = (Humano) personaje.getEsbirros().get(j);
                //NUMERO DE ESBIRROS
                bw.write("TIPO_ESBIRRO: ");

                bw.write(personaje.getTipo());
                bw.newLine();

                //NOMBRE DE ESBIRROS
                bw.write("NOMBRE_ESBIRRO: ");
                bw.write(humano.getNombre());
                bw.newLine();

                //VIDA DE ESBIRROS
                bw.write("VIDA_ESBIRRO: ");
                bw.write(humano.getHp());
                bw.newLine();

                //LEALTAD ESBIRRO HUMANO
                bw.write("LELTAD: ");
                if (humano.getLealtad() == Humano.Lealtad.ALTA) {
                    bw.write("ALTA");
                } else if (humano.getLealtad() == Humano.Lealtad.MEDIA) {
                    bw.write("MEDIA");
                } else if (humano.getLealtad() == Humano.Lealtad.BAJA) {
                    bw.write("BAJA");
                }
                bw.newLine();

            } else if (personaje.getEsbirros().get(j).getTipo().equals("GHOUL")) {
                Ghoul ghoul = (Ghoul) personaje.getEsbirros().get(j);
                //NUMERO DE ESBIRRO
                bw.write("TIPO_ESBIRRO: ");
                bw.write(personaje.getTipo());
                bw.newLine();

                //NOMBRE DE ESBIRRO
                bw.write("NOMBRE_ESBIRRO: ");
                bw.write(ghoul.getNombre());
                bw.newLine();

                //VIDA DE ESBIRRO
                bw.write("VIDA_ESBIRRO: ");
                bw.write(ghoul.getHp());
                bw.newLine();

                //DEPENDENCIA ESBIRRO
                bw.write("DEPENDENCIA: ");
                bw.write(ghoul.getDependencia());
                bw.newLine();

            } else if (personaje.getEsbirros().get(j).getTipo().equals("DEMONIO")) {
                Demonio demonio = (Demonio) personaje.getEsbirros().get(j);
                //TIPO DE ESBIRRO
                bw.write("TIPO_ESBIRRO: ");

                bw.write(personaje.getTipo());
                bw.newLine();

                //NOMBRE DE ESBIRRO
                bw.write("NOMBRE_ESBIRRO: ");
                bw.write(demonio.getNombre());
                bw.newLine();

                //VIDA ESBIRRO
                bw.write("VIDA_ESBIRRO: ");
                bw.write(demonio.getHp());
                bw.newLine();

                //DESCRIPCION / PACTO
                bw.write("DESCRIPCION: ");
                bw.write(demonio.getDescripcion());
                bw.newLine();

                //ESBIRROS EXTRA
                //NUMERO DE ESBIRROS EXTRA
                bw.write("NUMERO_ESBIRROS_EXTRA: ");
                bw.write(desafio.getDesafiante().getPersonaje().getEsbirros().size());
                bw.newLine();
                escrituraEsbirrosDesafiante(desafio, personaje, bw);
            }
        }
    }

    private void escrituraVampiroContrincante(Desafio desafio, BufferedWriter bw) throws IOException {

        Vampiro vampiro = (Vampiro) desafio.getContrincante().getPersonaje();
        Disciplina disciplina = (Disciplina) vampiro.getHabilidad();

        //TIPO PERSONAJE
        bw.write("TIPO_PERSONAJE: ");
        bw.write(desafio.getContrincante().getPersonaje().getTipo());
        bw.newLine();
        //NOMBRE PERSONAJE
        bw.write("NOMBRE_PERSONAJE: ");
        bw.write(desafio.getContrincante().getPersonaje().getNombre());
        bw.newLine();
        //PUNTOS DE SANGRE
        bw.write("SANGRE: ");
        bw.write(vampiro.getSangre());
        bw.newLine();
        //NOMBRE DE HABILIDAD
        bw.write("NOMNRE_HABILIDAD: ");
        bw.write(disciplina.getNombre());
        bw.newLine();

        //VALOR ATAQUE
        bw.write("VALOR_ATAQUE: ");
        bw.write(disciplina.getAtaque());
        bw.newLine();

        //VALOR DEFENSA
        bw.write("VALOR_DEFENSA: ");
        bw.write(disciplina.getDefensa());
        bw.newLine();

        //COSTE HABILIDAD
        bw.write("COSATE_HABILIDAD: ");
        bw.write(disciplina.getCoste());
        bw.newLine();

        //ARMAS
        bw.write("NUMERO_ARMAS: ");
        bw.write(desafio.getContrincante().getPersonaje().getArmas().size());
        bw.newLine();

        for (int variableArma = 0; variableArma < (desafio.getContrincante().getPersonaje().getArmas().size()); variableArma++) {
            Arma arma = desafio.getContrincante().getPersonaje().getArmas().get(variableArma);
            bw.write("NOMBRE_ARMA: ");
            bw.write(arma.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA: ");
            bw.write(arma.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA:");
            bw.write(arma.getModDefensa());
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA: ");
            if (arma.isSingleHand()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();

        }
        bw.newLine();

        //NUMERO DE ARMAS ACTIVAS
        bw.write("NUMERO_ARMAS_ACTIVAS: ");
        bw.write(desafio.getContrincante().getPersonaje().getArmasActivas().size());
        bw.newLine();
        for (int variableArmaActiva = 0; variableArmaActiva < (desafio.getContrincante().getPersonaje().getArmasActivas().size()); variableArmaActiva++) {
            Arma armaActiva = (Arma) vampiro.getArmasActivas().get(variableArmaActiva);

            bw.write("NOMBRE_ARMAS_ACTIVAS: ");
            bw.write(armaActiva.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA_ACTIVAS:");
            bw.write(armaActiva.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA_ACTIVAS: ");
            bw.write(armaActiva.getModDefensa());
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA: ");
            if (armaActiva.isSingleHand()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();
        }
        bw.newLine();

        //ARMADURAS
        //NUMERO DE ARMADURAS
        bw.write("NUMERO_ARMADURAS: ");
        bw.write(desafio.getContrincante().getPersonaje().getArmaduras().size());
        bw.newLine();
        for (int j = 0; j < (desafio.getContrincante().getPersonaje().getArmaduras().size()); j++) {
            Armadura armadura = (Armadura) vampiro.getArmaduras().get(j);
            bw.write("NOMBRE_ARMADURA: ");
            bw.write(armadura.getNombre());
            bw.newLine();

            bw.write("DEFENSA_ARMADURA: ");
            bw.write(armadura.getModDefensa());
            bw.newLine();

            bw.write("ATAQUE_ARMADURA: ");
            bw.write(armadura.getModAtaque());
            bw.newLine();
        }
        bw.newLine();

        //EDAD VAMPIRO
        bw.write("EDAD_VAMPIRO: ");
        bw.write(vampiro.getEdad());
        bw.newLine();

        //ESBIRROS
        //NUMERO DE ESBIRROS
        bw.write("NUMERO_ESBIRROS: ");
        bw.write(desafio.getContrincante().getPersonaje().getEsbirros().size());
        bw.newLine();

        //ESBIRROS
        escrituraEsbirrosContrincante(desafio, vampiro, bw);

        bw.write("FIN_USUARIO");
        bw.newLine();
    }

    private void escrituraLicantropoContrincante(Desafio desafio, BufferedWriter bw) throws IOException {

        Licantropo licantropo = (Licantropo) desafio.getContrincante().getPersonaje();
        Disciplina disciplina = (Disciplina) licantropo.getHabilidad();

        //TIPO PERSONAJE
        bw.write("TIPO_PERSONAJE: ");
        bw.write(desafio.getContrincante().getPersonaje().getTipo());
        bw.newLine();
        //NOMBRE PERSONAJE
        bw.write("NOMBRE_PERSONAJE: ");
        bw.write(desafio.getContrincante().getPersonaje().getNombre());
        bw.newLine();

        //PUNTOS DE SANGRE
        bw.write("RABIA: ");
        bw.write(licantropo.getRabia());
        bw.newLine();

        //NUMERO ARMAS
        bw.write("NUMERO_ARMAS: ");
        bw.write(desafio.getContrincante().getPersonaje().getArmas().size());
        bw.newLine();

        for (int variableArma = 0; variableArma < (desafio.getContrincante().getPersonaje().getArmas().size()); variableArma++) {
            Arma arma = desafio.getContrincante().getPersonaje().getArmas().get(variableArma);
            bw.write("NOMBRE_ARMA: ");
            bw.write(arma.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA: ");
            bw.write(arma.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA: ");
            bw.write(arma.getModDefensa());
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA: ");
            if (arma.isSingleHand()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();

        }
        bw.newLine();

        //NUMERO DE ARMAS ACTIVAS
        bw.write("NUMERO_ARMAS_ACTIVAS: ");
        bw.write(desafio.getContrincante().getPersonaje().getArmasActivas().size());
        bw.newLine();
        for (int variableArmaActiva = 0; variableArmaActiva < (desafio.getContrincante().getPersonaje().getArmasActivas().size()); variableArmaActiva++) {
            Arma armaActiva = (Arma) licantropo.getArmasActivas().get(variableArmaActiva);

            bw.write("NOMBRE_ARMAS_ACTIVAS: ");
            bw.write(armaActiva.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA_ACTIVAS:");
            bw.write(armaActiva.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA_ACTIVAS: ");
            bw.write(armaActiva.getModDefensa());
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA: ");
            if (armaActiva.isSingleHand()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();
        }
        bw.newLine();

        //ARMADURAS
        //NUMERO DE ARMADURAS
        bw.write("NUMERO_ARMADURAS: ");
        bw.write(desafio.getContrincante().getPersonaje().getArmaduras().size());
        bw.newLine();
        for (int j = 0; j < (desafio.getContrincante().getPersonaje().getArmaduras().size()); j++) {
            Armadura armadura = (Armadura) licantropo.getArmaduras().get(j);
            bw.write("NOMBRE_ARMADURA: ");
            bw.write(armadura.getNombre());
            bw.newLine();

            bw.write("DEFENSA_ARMADURA: ");
            bw.write(armadura.getModDefensa());
            bw.newLine();

            bw.write("ATAQUE_ARMADURA: ");
            bw.write(armadura.getModAtaque());
            bw.newLine();
        }
        bw.newLine();

        //ARMADURA ACTIVA / EQUIPADA
        bw.write("NOMBRE_ARMADURA_ACTIVA: ");
        bw.write(desafio.getContrincante().getPersonaje().getArmaduraActiva().getNombre());
        bw.newLine();

        //DEFENSA ARMADURA ACTIVA / EQUIPADA
        bw.write("DEFENSA_ARMADURA_ACTIVA: ");
        bw.write(desafio.getContrincante().getPersonaje().getArmaduraActiva().getModDefensa());
        bw.newLine();

        //ATAQUE ARMADURA ACTIVA / EQUIPADA
        bw.write("ATAQUE_ARMADURA_ACTIVA: ");
        bw.write(desafio.getContrincante().getPersonaje().getArmaduraActiva().getModAtaque());
        bw.newLine();

        //CANTIDAD ORO
        bw.write("ORO: ");
        bw.write(desafio.getContrincante().getPersonaje().getOro());
        bw.newLine();

        //DEBLIDADES
        //NUMERO DE DEBLIDADES
        bw.write("NUMERO_DEBILIDADES: ");
        bw.write(desafio.getContrincante().getPersonaje().getDebilidades().size());
        bw.newLine();
        for (int j = 0; j < (desafio.getContrincante().getPersonaje().getArmaduras().size()); j++) {
            Debilidad debilidad = (Debilidad) licantropo.getDebilidades().get(j);
            bw.write("NOMBRE_DEBILIADAD: ");
            bw.write(debilidad.getNombre());
            bw.newLine();

            bw.write("VALOR_DEBILIADAD:");
            bw.write(debilidad.getValor());
            bw.newLine();
        }
        bw.newLine();

        //FORTALEZAS
        //NUMERO DE FORTALEZAS
        bw.write("NUMERO_FORTALEZAS: ");
        bw.write(desafio.getContrincante().getPersonaje().getFortalezas().size());
        bw.newLine();
        for (int j = 0; j < (desafio.getContrincante().getPersonaje().getArmaduras().size()); j++) {
            Fortaleza fortaleza = (Fortaleza) licantropo.getFortalezas().get(j);
            bw.write("NOMBRE_FORTALEZA:");
            bw.write(fortaleza.getNombre());
            bw.newLine();

            bw.write("VALOR_FORTALEZA:");
            bw.write(fortaleza.getValor());
            bw.newLine();
        }
        bw.newLine();

        //ESBIRROS
        //NUMERO DE ESBIRROS
        bw.write("NUMERO_ESBIRROS: ");
        bw.write(desafio.getContrincante().getPersonaje().getEsbirros().size());
        bw.newLine();

        //ESBIRROS
        escrituraEsbirrosContrincante(desafio, licantropo, bw);

        bw.write("FIN_USUARIO");
        bw.newLine();
    }

    private void escrituraCazadorContrincante(Desafio desafio, BufferedWriter bw) throws IOException {

        Cazador cazador = (Cazador) desafio.getContrincante().getPersonaje();
        Disciplina disciplina = (Disciplina) cazador.getHabilidad();

        //TIPO PERSONAJE
        bw.write("TIPO_PERSONAJE: ");
        bw.write(desafio.getContrincante().getPersonaje().getTipo());
        bw.newLine();
        //NOMBRE PERSONAJE
        bw.write("NOMBRE_PERSONAJE: ");
        bw.write(desafio.getContrincante().getPersonaje().getNombre());
        bw.newLine();

        //NOMBRE HABILDIAD
        bw.write("NOMBRE_HABILIDAD: ");
        bw.write(cazador.getNombre());
        bw.newLine();

        //ATAQUE HABILIDAD
        bw.write("ATAQUE_HABILIDAD: ");
        bw.write(cazador.getHabilidad().getAtaque());
        bw.newLine();

        //DEBILIDAD HABILIDAD
        bw.write("DEFENSA_HABILIDAD: ");
        bw.write(cazador.getHabilidad().getDefensa());
        bw.newLine();

        //EDAD CAZADOR
        bw.write("EDAD_CAZADOR: ");
        bw.write(cazador.getVoluntad());  //LA EDAD ES LA VOLUNTAD DEL CAZADOR
        bw.newLine();

        //ARMAS
        //NUMERO ARMAS
        bw.write("NUMERO_ARMAS: ");
        bw.write(desafio.getContrincante().getPersonaje().getArmas().size());
        bw.newLine();

        for (int variableArma = 0; variableArma < (desafio.getContrincante().getPersonaje().getArmas().size()); variableArma++) {
            Arma arma = desafio.getContrincante().getPersonaje().getArmas().get(variableArma);
            bw.write("NOMBRE_ARMA:");
            bw.write(arma.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA:");
            bw.write(arma.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA:");
            bw.write(arma.getModDefensa());
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA:");
            if (arma.isSingleHand()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();

        }
        bw.newLine();

        //ARMAS ACTIVAS
        //NUMERO DE ARMAS ACTIVAS
        bw.write("NUMERO_ARMAS_ACTIVAS: ");
        bw.write(desafio.getContrincante().getPersonaje().getArmasActivas().size());
        bw.newLine();
        for (int variableArmaActiva = 0; variableArmaActiva < (desafio.getContrincante().getPersonaje().getArmasActivas().size()); variableArmaActiva++) {
            Arma armaActiva = (Arma) cazador.getArmasActivas().get(variableArmaActiva);

            bw.write("NOMBRE_ARMAS_ACTIVAS:");
            bw.write(armaActiva.getNombre());
            bw.newLine();

            bw.write("ATAQUE_ARMA_ACTIVAS:");
            bw.write(armaActiva.getModAtaque());
            bw.newLine();

            bw.write("DEFENSA_ARMA_ACTIVAS:");
            bw.write(armaActiva.getModDefensa());
            bw.newLine();

            //si es true es de 1 mano, si es false es de dos manos
            bw.write("EMPUÑADURA:");
            if (armaActiva.isSingleHand()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();
        }
        bw.newLine();

        //ARMADURAS
        //NUMERO DE ARMADURAS
        bw.write("NUMERO_ARMADURAS: ");
        bw.write(desafio.getContrincante().getPersonaje().getArmaduras().size());
        bw.newLine();
        for (int j = 0; j < (desafio.getContrincante().getPersonaje().getArmaduras().size()); j++) {
            Armadura armadura = (Armadura) cazador.getArmaduras().get(j);
            bw.write("NOMBRE_ARMADURA:");
            bw.write(armadura.getNombre());
            bw.newLine();

            bw.write("DEFENSA_ARMADURA:");
            bw.write(armadura.getModDefensa());
            bw.newLine();

            bw.write("ATAQUE_ARMADURA:");
            bw.write(armadura.getModAtaque());
            bw.newLine();
        }
        bw.newLine();

        //ARMADURAS EQUIPADA
        bw.write("NOMBRE_ARMADURA_ACTIVA:");
        bw.write(desafio.getContrincante().getPersonaje().getArmaduraActiva().getNombre());
        bw.newLine();

        bw.write("DEFENSA_ARMADURA_ACTIVA:");
        bw.write(desafio.getContrincante().getPersonaje().getArmaduraActiva().getModDefensa());
        bw.newLine();

        bw.write("ATAQUE_ARMADURA_ACTIVA:");
        bw.write(desafio.getContrincante().getPersonaje().getArmaduraActiva().getModAtaque());
        bw.newLine();

        bw.newLine();

        //CANTIDAD ORO
        bw.write("ORO: ");
        bw.write(cazador.getOro());
        bw.newLine();

        //CANTIDAD VDA
        bw.write("VIDA: ");
        bw.write(cazador.getHp());
        bw.newLine();

        //PODER
        bw.write("PODER: ");
        bw.write(cazador.getPoder());
        bw.newLine();

        //DEBILIDADES
        //NUMERO DE DEBILIDADES
        bw.write("NUMERO_DEBILIDADES: ");
        bw.write(desafio.getContrincante().getPersonaje().getDebilidades().size());
        bw.newLine();
        for (int j = 0; j < (desafio.getContrincante().getPersonaje().getArmaduras().size()); j++) {
            Debilidad debilidad = (Debilidad) cazador.getDebilidades().get(j);
            bw.write("NOMBRE_DEBILIDAD:");
            bw.write(debilidad.getNombre());
            bw.newLine();

            bw.write("VALOR_DEBILIDAD:");
            bw.write(debilidad.getValor());
            bw.newLine();
        }
        bw.newLine();

        //FORTALEZAS
        //NUMERO DE FORTALEZAS
        bw.write("NUMERO_FORTALEZAS: ");
        bw.write(desafio.getContrincante().getPersonaje().getDebilidades().size());
        bw.newLine();
        for (int j = 0; j < (desafio.getContrincante().getPersonaje().getArmaduras().size()); j++) {
            Fortaleza fortaleza = (Fortaleza) cazador.getFortalezas().get(j);
            bw.write("NOMBRE_FORTALEZA:");
            bw.write(fortaleza.getNombre());
            bw.newLine();

            bw.write("VALOR_FORTALEZA:");
            bw.write(fortaleza.getValor());
            bw.newLine();
        }
        bw.newLine();

        //ESBIRROS
        //NUMERO DE ESBIRROS
        bw.write("NUMERO_ESBIRROS: ");
        bw.write(desafio.getContrincante().getPersonaje().getEsbirros().size());
        bw.newLine();

        escrituraEsbirrosContrincante(desafio, cazador, bw);

        bw.write("FIN_USUARIO");
        bw.newLine();
    }

    private void escrituraEsbirrosContrincante(Desafio desafio, Personaje personaje, BufferedWriter bw) throws IOException {
        for (int j = 0; j < (desafio.getContrincante().getPersonaje().getEsbirros().size()); j++) {
            if (personaje.getEsbirros().get(j).getTipo().equals("HUMANO")) {
                Humano humano = (Humano) personaje.getEsbirros().get(j);
                //NUMERO DE ESBIRROS
                bw.write("TIPO_ESBIRRO: ");

                bw.write(personaje.getTipo());
                bw.newLine();

                //NOMBRE DE ESBIRROS
                bw.write("NOMBRE_ESBIRRO: ");
                bw.write(humano.getNombre());
                bw.newLine();

                //VIDA DE ESBIRROS
                bw.write("VIDA_ESBIRRO: ");
                bw.write(humano.getHp());
                bw.newLine();

                //LEALTAD ESBIRRO HUMANO
                bw.write("LELTAD: ");
                if (humano.getLealtad() == Humano.Lealtad.ALTA) {
                    bw.write("ALTA");
                } else if (humano.getLealtad() == Humano.Lealtad.MEDIA) {
                    bw.write("MEDIA");
                } else if (humano.getLealtad() == Humano.Lealtad.BAJA) {
                    bw.write("BAJA");
                }
                bw.newLine();

            } else if (personaje.getEsbirros().get(j).getTipo().equals("GHOUL")) {
                Ghoul ghoul = (Ghoul) personaje.getEsbirros().get(j);
                //NUMERO DE ESBIRRO
                bw.write("TIPO_ESBIRRO: ");
                bw.write(personaje.getTipo());
                bw.newLine();

                //NOMBRE DE ESBIRRO
                bw.write("NOMBRE_ESBIRRO: ");
                bw.write(ghoul.getNombre());
                bw.newLine();

                //VIDA DE ESBIRRO
                bw.write("VIDA_ESBIRRO: ");
                bw.write(ghoul.getHp());
                bw.newLine();

                //DEPENDENCIA ESBIRRO
                bw.write("DEPENDENCIA: ");
                bw.write(ghoul.getDependencia());
                bw.newLine();

            } else if (personaje.getEsbirros().get(j).getTipo().equals("DEMONIO")) {
                Demonio demonio = (Demonio) personaje.getEsbirros().get(j);
                //TIPO DE ESBIRRO
                bw.write("TIPO_ESBIRRO: ");

                bw.write(personaje.getTipo());
                bw.newLine();

                //NOMBRE DE ESBIRRO
                bw.write("NOMBRE_ESBIRRO: ");
                bw.write(demonio.getNombre());
                bw.newLine();

                //VIDA ESBIRRO
                bw.write("VIDA_ESBIRRO: ");
                bw.write(demonio.getHp());
                bw.newLine();

                //DESCRIPCION / PACTO
                bw.write("DESCRIPCION: ");
                bw.write(demonio.getDescripcion());
                bw.newLine();

                //ESBIRROS EXTRA
                //NUMERO DE ESBIRROS EXTRA
                bw.write("NUMERO_ESBIRROS_EXTRA: ");
                bw.write(desafio.getContrincante().getPersonaje().getEsbirros().size());
                bw.newLine();
                escrituraEsbirrosContrincante(desafio, personaje, bw);
            }
        }
    }

}
