package mp_grupo_m.Entidades;

import mp_grupo_m.Factorias.FactoriaCazadores;
import mp_grupo_m.Factorias.FactoriaVampiros;
import mp_grupo_m.Factorias.FactoriaLicantropos;
import mp_grupo_m.Sistema;
import mp_grupo_m.Terminal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Cliente extends User {

    private String registro;
    private Personaje personaje;

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public Vampiro crearVampiro() {

        boolean rightValue;
        boolean[] rightWeapon;
        boolean[] aux1 = new boolean[]{true, true};
        boolean[] aux2 = new boolean[]{true, false};

        FactoriaVampiros factoriaVampiros = new FactoriaVampiros();
        Terminal terminal = new Terminal();
        Vampiro vampiro = new Vampiro();
        Disciplina disciplina = new Disciplina();
        ArrayList<Arma> armas = new ArrayList<>();
        ArrayList<Arma> armasActivas = new ArrayList<>();
        ArrayList<Armadura> armaduras = new ArrayList<>();
        Debilidad debilidad = new Debilidad();
        Fortaleza fortaleza = new Fortaleza();
        ArrayList<Debilidad> debilidades = new ArrayList<>();
        ArrayList<Fortaleza> fortalezas = new ArrayList<>();
        Armadura armadura = new Armadura();
        Arma arma = new Arma();
        ArrayList<EsbirrosComposite> esbirros = new ArrayList<>();

        terminal.preguntarNombre();
        factoriaVampiros.inicializarNombre(vampiro);
        terminal.preguntarNombreHabilidad();
        factoriaVampiros.inicializarNombreHabilidad(disciplina);
        do {
            terminal.preguntarAtaqueHabilidad();
            rightValue = factoriaVampiros.inicializarAtaqueHabilidad(disciplina);
        } while (!rightValue);
        do {
            terminal.preguntarDefensaHabilidad();
            rightValue = factoriaVampiros.inicializarDefensaHabilidad(disciplina);
        } while (!rightValue);
        do {
            terminal.preguntarCosteHabilidad();
            rightValue = factoriaVampiros.inicializarCosteHabilidad(disciplina);
        } while (!rightValue);
        factoriaVampiros.setHabilidad(vampiro, disciplina);
        int numArmas;
        do {
            terminal.preguntarNumArmas();
            numArmas = factoriaVampiros.askNum();
        } while (numArmas < 1);
        for (int iterator = 1; iterator <= numArmas; iterator++) {
            arma = new Arma();
            terminal.preguntarNombreArma();
            factoriaVampiros.inicializarnNombreArma(arma);
            do {
                terminal.preguntarAtaqueArma();
                rightValue = factoriaVampiros.inicializarAtaqueArma(arma);
            } while (!rightValue);
            do {
                terminal.preguntarDefensaArma();
                rightValue = factoriaVampiros.inicializarDefensaArma(arma);
            } while (!rightValue);
            do {
                terminal.peguntarSingleHandArma();
                rightValue = factoriaVampiros.inicializarSingleHandArma(arma);
            } while (!rightValue);
            factoriaVampiros.addArma(armas, arma);
        }
        factoriaVampiros.setArmas(vampiro, armas);
        do {
            terminal.mostrarArmas(armas);
            rightWeapon = factoriaVampiros.addArmaActiva(arma, armas, armasActivas);
        } while (!Arrays.equals(rightWeapon, aux1) && !Arrays.equals(rightWeapon, aux2));
        if (Arrays.equals(rightWeapon, aux1)) {
            do {
                terminal.otroArma(armas);
                rightValue = factoriaVampiros.addArmaActiva2(arma, armas, armasActivas);
            } while (!rightValue);
        }
        factoriaVampiros.setArmasActivas(vampiro, armasActivas);
        int numArmaduras;
        do {
            terminal.preguntarNumArmaduras();
            numArmaduras = factoriaVampiros.askNum();
        } while (numArmaduras < 1);
        for (int iterator = 1; iterator <= numArmaduras; iterator++) {
            armadura = new Armadura();
            terminal.preguntarNombreArmadura();
            factoriaVampiros.inicializarnNombreArmadura(armadura);
            do {
                terminal.preguntarDefensaArmadura();
                rightValue = factoriaVampiros.inicializarDefensaArmadura(armadura);
            } while (!rightValue);
            do {
                terminal.preguntarAtaqueArmadura();
                rightValue = factoriaVampiros.inicializarAtaqueArmadura(armadura);
            } while (!rightValue);
            factoriaVampiros.addArmadura(armadura, armaduras);
        }
        factoriaVampiros.setArmaduras(vampiro, armaduras);
        do {
            terminal.mostrarArmaduras(armaduras);
            rightValue = factoriaVampiros.addArmaduraActiva(vampiro, armadura, armaduras);
        } while (!rightValue);
        do {
            terminal.preguntarOro();
            rightValue = factoriaVampiros.inicializarOro(vampiro);
        } while (!rightValue);
        do {
            terminal.preguntarHP();
            rightValue = factoriaVampiros.inicializarHP(vampiro);
        } while (!rightValue);
        do {
            terminal.preguntarPoder();
            rightValue = factoriaVampiros.inicializarPoder(vampiro);
        } while (!rightValue);
        terminal.peguntarNumDebilidades();
        int numDebilidades = factoriaVampiros.askNum();
        for (int iterator = 1; iterator <= numDebilidades; iterator++) {
            terminal.preguntarNombreDebilidad();
            factoriaVampiros.inicializarNombreDebilidad(debilidad);
            terminal.preguntarValorDebilidad();
            factoriaVampiros.inicializarValorDebilidad(debilidad);
            factoriaVampiros.addDebilidad(debilidades, debilidad);
        }
        factoriaVampiros.setDebilidades(vampiro, debilidades);
        terminal.peguntarNumFortalezas();
        int numFortalezas = factoriaVampiros.askNum();
        for (int iterator = 1; iterator <= numFortalezas; iterator++) {
            terminal.preguntarNombreFortaleza();
            factoriaVampiros.inicializarNombreFortaleza(fortaleza);
            terminal.preguntarValorFortaleza();
            factoriaVampiros.inicializarValorFortaleza(fortaleza);
            factoriaVampiros.addFortaleza(fortalezas, fortaleza);
        }
        factoriaVampiros.setFortalezas(vampiro, fortalezas);
        terminal.preguntarEdadVampiro();
        factoriaVampiros.setEdad(vampiro);
        vampiro.setSangre(0);
        terminal.preguntarNumEsbirros();
        int numEsbirros = factoriaVampiros.askNum();
        for (int iterator = 1; iterator <= numEsbirros; iterator++) {
            EsbirrosComposite esbirro = new EsbirrosComposite();
            esbirro = esbirro.crearEsbirro(true);
            esbirros.add(esbirro);
        }
        vampiro.setEsbirros(esbirros);
        return vampiro;
    }

    public Cazador crearCazador() {

        boolean rightValue;
        boolean[] rightWeapon;
        boolean[] aux1 = new boolean[]{true, true};
        boolean[] aux2 = new boolean[]{true, false};

        FactoriaCazadores factoriaCazadores = new FactoriaCazadores();
        Terminal terminal = new Terminal();
        Cazador cazador = new Cazador();
        Talento talento = new Talento();
        ArrayList<Arma> armas = new ArrayList<>();
        ArrayList<Arma> armasActivas = new ArrayList<>();
        ArrayList<Armadura> armaduras = new ArrayList<>();
        Debilidad debilidad = new Debilidad();
        Fortaleza fortaleza = new Fortaleza();
        ArrayList<Debilidad> debilidades = new ArrayList<>();
        ArrayList<Fortaleza> fortalezas = new ArrayList<>();
        Armadura armadura = new Armadura();
        Arma arma = new Arma();
        ArrayList<EsbirrosComposite> esbirros = new ArrayList<>();

        terminal.preguntarNombre();
        factoriaCazadores.inicializarNombre(cazador);
        terminal.preguntarNombreHabilidad();
        factoriaCazadores.inicializarNombreHabilidad(talento);
        do {
            terminal.preguntarAtaqueHabilidad();
            rightValue = factoriaCazadores.inicializarAtaqueHabilidad(talento);
        } while (!rightValue);
        do {
            terminal.preguntarDefensaHabilidad();
            rightValue = factoriaCazadores.inicializarDefensaHabilidad(talento);
        } while (!rightValue);
        terminal.preguntarEdadHabilidad();
        factoriaCazadores.inicializarEdadHabilidad(talento);
        factoriaCazadores.setHabilidad(cazador, talento);
        int numArmas;
        do {
            terminal.preguntarNumArmas();
            numArmas = factoriaCazadores.askNum();
        } while (numArmas < 1);
        for (int iterator = 1; iterator <= numArmas; iterator++) {
            arma = new Arma();
            terminal.preguntarNombreArma();
            factoriaCazadores.inicializarnNombreArma(arma);
            do {
                terminal.preguntarAtaqueArma();
                rightValue = factoriaCazadores.inicializarAtaqueArma(arma);
            } while (!rightValue);
            do {
                terminal.preguntarDefensaArma();
                rightValue = factoriaCazadores.inicializarDefensaArma(arma);
            } while (!rightValue);
            do {
                terminal.peguntarSingleHandArma();
                rightValue = factoriaCazadores.inicializarSingleHandArma(arma);
            } while (!rightValue);
            factoriaCazadores.addArma(armas, arma);
        }
        factoriaCazadores.setArmas(cazador, armas);
        do {
            terminal.mostrarArmas(armas);
            rightWeapon = factoriaCazadores.addArmaActiva(arma, armas, armasActivas);
        } while (!Arrays.equals(rightWeapon, aux1) && !Arrays.equals(rightWeapon, aux2));
        if (Arrays.equals(rightWeapon, aux1)) {
            do {
                terminal.otroArma(armas);
                rightValue = factoriaCazadores.addArmaActiva2(arma, armas, armasActivas);
            } while (!rightValue);
        }
        factoriaCazadores.setArmasActivas(cazador, armasActivas);
        int numArmaduras;
        do {
            terminal.preguntarNumArmaduras();
            numArmaduras = factoriaCazadores.askNum();
        } while (numArmaduras < 1);
        for (int iterator = 1; iterator <= numArmaduras; iterator++) {
            armadura = new Armadura();
            terminal.preguntarNombreArmadura();
            factoriaCazadores.inicializarnNombreArmadura(armadura);
            do {
                terminal.preguntarDefensaArmadura();
                rightValue = factoriaCazadores.inicializarDefensaArmadura(armadura);
            } while (!rightValue);
            do {
                terminal.preguntarAtaqueArmadura();
                rightValue = factoriaCazadores.inicializarAtaqueArmadura(armadura);
            } while (!rightValue);
            factoriaCazadores.addArmadura(armadura, armaduras);
        }
        factoriaCazadores.setArmaduras(cazador, armaduras);
        do {
            terminal.mostrarArmaduras(armaduras);
            rightValue = factoriaCazadores.addArmaduraActiva(cazador, armadura, armaduras);
        } while (!rightValue);
        do {
            terminal.preguntarOro();
            rightValue = factoriaCazadores.inicializarOro(cazador);
        } while (!rightValue);
        do {
            terminal.preguntarHP();
            rightValue = factoriaCazadores.inicializarHP(cazador);
        } while (!rightValue);
        do {
            terminal.preguntarPoder();
            rightValue = factoriaCazadores.inicializarPoder(cazador);
        } while (!rightValue);
        terminal.peguntarNumDebilidades();
        int numDebilidades = factoriaCazadores.askNum();
        for (int iterator = 1; iterator <= numDebilidades; iterator++) {
            terminal.preguntarNombreDebilidad();
            factoriaCazadores.inicializarNombreDebilidad(debilidad);
            terminal.preguntarValorDebilidad();
            factoriaCazadores.inicializarValorDebilidad(debilidad);
            factoriaCazadores.addDebilidad(debilidades, debilidad);
        }
        factoriaCazadores.setDebilidades(cazador, debilidades);
        terminal.peguntarNumFortalezas();
        int numFortalezas = factoriaCazadores.askNum();
        for (int iterator = 1; iterator <= numFortalezas; iterator++) {
            terminal.preguntarNombreFortaleza();
            factoriaCazadores.inicializarNombreFortaleza(fortaleza);
            terminal.preguntarValorFortaleza();
            factoriaCazadores.inicializarValorFortaleza(fortaleza);
            factoriaCazadores.addFortaleza(fortalezas, fortaleza);
        }
        factoriaCazadores.setFortalezas(cazador, fortalezas);
        terminal.preguntarNumEsbirros();
        int numEsbirros = factoriaCazadores.askNum();
        for (int iterator = 1; iterator <= numEsbirros; iterator++) {
            EsbirrosComposite esbirro = new EsbirrosComposite();
            esbirro = esbirro.crearEsbirro(false);
            esbirros.add(esbirro);
        }
        cazador.setEsbirros(esbirros);
        cazador.setVoluntad(3);
        return cazador;
    }

    public Licantropo crearLicantropo() {

        boolean rightValue;
        boolean[] rightWeapon;
        boolean[] aux1 = new boolean[]{true, true};
        boolean[] aux2 = new boolean[]{true, false};

        FactoriaLicantropos FL = new FactoriaLicantropos();
        Terminal terminal = new Terminal();
        Licantropo licantropo = new Licantropo();
        Don don = new Don();
        Arma arma = new Arma();
        ArrayList<Arma> armas = new ArrayList<>();
        ArrayList<Arma> armasActivas = new ArrayList<>();
        Armadura armadura = new Armadura();
        ArrayList<Armadura> armaduras = new ArrayList<>();
        Debilidad debilidad = new Debilidad();
        Fortaleza fortaleza = new Fortaleza();
        ArrayList<Debilidad> debilidades = new ArrayList<>();
        ArrayList<Fortaleza> fortalezas = new ArrayList<>();
        ArrayList<EsbirrosComposite> esbirros = new ArrayList<>();

        terminal.preguntarNombre();
        FL.inicializarNombre(licantropo);
        terminal.preguntarNombreHabilidad();
        FL.inicializarNombreHabilidad(don);
        licantropo.setRabia(0);
        do {
            terminal.preguntarRabiaHabilidad();
            rightValue = FL.inicializarRabiaHabilidad(don);
        } while (!rightValue);
        FL.setHabilidad(licantropo, don);
        terminal.preguntarNumArmas();
        int numArmas = FL.askNum();
        for (int iterator = 1; iterator <= numArmas; iterator++) {
            arma = new Arma();
            terminal.preguntarNombreArma();
            FL.inicializarnNombreArma(arma);
            do {
                terminal.preguntarAtaqueArma();
                rightValue = FL.inicializarAtaqueArma(arma);
            } while (!rightValue);
            do {
                terminal.preguntarDefensaArma();
                rightValue = FL.inicializarDefensaArma(arma);
            } while (!rightValue);
            do {
                terminal.peguntarSingleHandArma();
                rightValue = FL.inicializarSingleHandArma(arma);
            } while (!rightValue);
            FL.addArma(armas, arma);
        }
        FL.setArmas(licantropo, armas);
        do {
            terminal.mostrarArmas(armas);
            rightWeapon = FL.addArmaActiva(arma, armas, armasActivas);
        } while (!Arrays.equals(rightWeapon, aux1) && !Arrays.equals(rightWeapon, aux2));
        if (Arrays.equals(rightWeapon, aux1)) {
            do {
                terminal.otroArma(armas);
                rightValue = FL.addArmaActiva2(arma, armas, armasActivas);
            } while (!rightValue);
        }
        FL.setArmasActivas(licantropo, armasActivas);

        terminal.preguntarNumArmaduras();
        int numArmaduras = FL.askNum();
        for (int iterator = 1; iterator <= numArmaduras; iterator++) {
            armadura = new Armadura();
            terminal.preguntarNombreArmadura();
            FL.inicializarNombreArmadura(armadura);
            do {
                terminal.preguntarDefensaArmadura();
                rightValue = FL.inicializarDefensaArmadura(armadura);
            } while (!rightValue);
            do {
                terminal.preguntarAtaqueArmadura();
                rightValue = FL.inicializarAtaqueArmadura(arma);
            } while (!rightValue);
            FL.addArmadura(armadura, armaduras);
        }
        FL.setArmaduras(licantropo, armaduras);
        do {
            terminal.mostrarArmaduras(armaduras);
            rightValue = FL.addArmaduraActiva(licantropo, armadura, armaduras);
        } while (!rightValue);
        do {
            terminal.preguntarOro();
            rightValue = FL.inicializarOro(licantropo);
        } while (!rightValue);
        do {
            terminal.preguntarHP();
            rightValue = FL.inicializarHP(licantropo);
        } while (!rightValue);
        do {
            terminal.preguntarPoder();
            rightValue = FL.inicializarPoder(licantropo);
        } while (!rightValue);
        terminal.peguntarNumDebilidades();
        int numDebilidades = FL.askNum();
        for (int iterator = 1; iterator <= numDebilidades; iterator++) {
            terminal.preguntarNombreDebilidad();
            FL.inicializarNombreDebilidad(debilidad);
            terminal.preguntarValorDebilidad();
            FL.inicializarValorDebilidad(debilidad);
            FL.addDebilidad(debilidades, debilidad);
        }
        FL.setDebilidades(licantropo, debilidades);
        terminal.peguntarNumFortalezas();
        int numFortalezas = FL.askNum();
        for (int iterator = 1; iterator <= numFortalezas; iterator++) {
            terminal.preguntarNombreFortaleza();
            FL.inicializarNombreFortaleza(fortaleza);
            terminal.preguntarValorFortaleza();
            FL.inicializarValorFortaleza(fortaleza);
            FL.addFortaleza(fortalezas, fortaleza);
        }
        FL.setFortalezas(licantropo, fortalezas);
        terminal.preguntarNumEsbirros();
        int numEsbirros = FL.askNum();
        for (int iterator = 1; iterator <= numEsbirros; iterator++) {
            EsbirrosComposite esbirro = new EsbirrosComposite();
            esbirro = esbirro.crearEsbirro(true);
            esbirros.add(esbirro);
        }
        licantropo.setEsbirros(esbirros);
        return licantropo;
    }

    public void eliminarPersonaje(Cliente cliente) {
        Terminal terminal = new Terminal();
        terminal.confirmarDeletePersonaje();
        Scanner sc = new Scanner(System.in);
        boolean delete = sc.nextInt() == 1;
        if (delete) {
            cliente.setPersonaje(null);
            terminal.personajeEliminado();
        }
    }

    public void seleccionarEquipo(Cliente cliente) {

        boolean rightValue;
        boolean[] rightWeapon;
        boolean[] aux1 = new boolean[]{true, true};
        boolean[] aux2 = new boolean[]{true, false};

        ArrayList<Arma> armasActivas = new ArrayList<>();
        Terminal terminal = new Terminal();
        do {
            terminal.mostrarArmas(cliente.getPersonaje().getArmas());
            rightWeapon = addArmaActiva(cliente.getPersonaje().getArmas(), armasActivas);
        } while (!Arrays.equals(rightWeapon, aux1) && !Arrays.equals(rightWeapon, aux2));
        if (Arrays.equals(rightWeapon, aux1)) {
            do {
                terminal.otroArma(cliente.getPersonaje().getArmas());
                rightValue = addArmaActiva2(cliente.getPersonaje().getArmas(), armasActivas);
            } while (!rightValue);
        }
        cliente.getPersonaje().setArmasActivas(armasActivas);
        do {
            terminal.mostrarArmaduras(cliente.getPersonaje().getArmaduras());
            rightValue = addArmaduraActiva(cliente.getPersonaje(), cliente.getPersonaje().getArmaduras());
        } while (!rightValue);
        terminal.finishEquipar();
    }

    public void desafiar(ArrayList<Cliente> listaClientes, Cliente cliente, Sistema sistema) {
        Desafio desafio = new Desafio();
        desafio.crearDesafio(listaClientes, cliente, sistema);
    }

    public void eliminarCuenta(Cliente cliente, Sistema sistema) {
        Terminal terminal = new Terminal();
        Scanner sc = new Scanner(System.in);
        terminal.confirmarDelete();
        boolean delete = sc.nextInt() == 1;
        if (delete) {
            //leer fichero de clientes
            ArrayList<Cliente> listaClientes = new ArrayList<>();
            listaClientes.add(cliente);
            for (int i = 0; i <= listaClientes.size(); i++) {
                if (listaClientes.get(i).getRegistro().equals(cliente.getRegistro())) {
                    listaClientes.remove(i);
                }
            }
            //sobreescribir fichero
            terminal.cerrarSesion();
            sistema.selector();
        }
    }

    private boolean[] addArmaActiva(ArrayList<Arma> armas, ArrayList<Arma> armasActivas) {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        if ((opcion < 1) || (opcion > armas.size() + 1)) {
            return new boolean[]{false, false};
        }
        armasActivas.add(armas.get(opcion - 1));
        return new boolean[]{true, armas.get(opcion - 1).isSingleHand()};
    }

    private boolean addArmaActiva2(ArrayList<Arma> armas, ArrayList<Arma> armasActivas) {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        if ((opcion < 0) || (opcion > armas.size() + 1)) {
            return false;
        }
        if (opcion == 0) {
            return true;
        }
        if (!armas.get(opcion + 1).getNombre().equals(armasActivas.get(0).getNombre()) && armas.get(opcion + 1).isSingleHand()) {
            armasActivas.add(armas.get(opcion - 1));
            return true;
        }
        return false;
    }

    private boolean addArmaduraActiva(Personaje personaje, ArrayList<Armadura> armaduras) {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        if ((opcion < 1) || (opcion > armaduras.size() + 1)) {
            return false;
        }
        Armadura armadura = armaduras.get(opcion - 1);
        personaje.setArmaduraActiva(armadura);
        return true;
    }

    public String generarNumerRegistro() {
        boolean valido = false;
        Cliente cliente = new Cliente();
        ArrayList<Cliente> lista = new ArrayList<>();
        lista.add(cliente);
        String strBuilder = null;
        //crear del fichero lista de clientes para coger sus registros y comparar
        while (!valido) {
            strBuilder = String.valueOf(getLetra()) +
                    getNumber() +
                    getNumber() +
                    getLetra() +
                    getLetra();
            for (Cliente value : lista) {
                if (!(value.getRegistro().equals(strBuilder))) {
                    valido = true;
                } else {
                    strBuilder = null;
                }
            }
        }
        return strBuilder;
    }

    public char getLetra() {
        char paramChar = (char) (Math.random() * 26 + 'a');
        return paramChar;
    }

    public char getNumber() {
        int N = (int) (Math.random() * 10 + '0');
        return (char) N;
    }

    public void consultarRanking() {
        Terminal terminal = new Terminal();
        terminal.ranking();
        Cliente cliente = new Cliente();
        ArrayList<Cliente> lista = new ArrayList<>();
        //coger lista clientes de ficheros y guardarlos en lista
        ArrayList<Cliente> listaAux = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            boolean encontrado = false;
            for (int j = 0; j < listaAux.size(); j++) {
                if (lista.get(i).getPersonaje() != null && lista.get(i).getPersonaje().getOro() > listaAux.get(j).getPersonaje().getOro()) {
                    encontrado = true;
                    listaAux.add(j, lista.get(i));
                    break;
                }
            }
            if (!encontrado) {
                listaAux.add(lista.get(i));
            }
        }
        terminal.mostrarRanking(listaAux);
    }
}

