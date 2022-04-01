package mp_grupo_m;

import mp_grupo_m.Entidades.*;
import mp_grupo_m.Factorias.FactoriaVampiros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public void selector() {
        Terminal terminal = new Terminal();
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                //comprobar que el usuario no tiene un personaje ya creado, mandar un mensaje en dicho caso
                terminal.mostrarFactorias();
                selectorFactoria();
            case 2:
                terminal.WIP();
            case 3:
                terminal.WIP();
            case 4:
                terminal.WIP();
            case 5:
                terminal.WIP();
            case 6:
                terminal.WIP();
            case 7:
                terminal.WIP();
            default:
                terminal.WIP();
        }
    }

    private void selectorFactoria() {
        Terminal terminal = new Terminal();
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                crearVampiro();
            case 2:
                terminal.WIP();
            case 3:
                terminal.WIP();
            default:
                terminal.error();
        }
    }

    private void crearVampiro() {

        boolean rightValue;
        boolean[] rightWeapon;
        boolean[] aux1 = new boolean[]{true, true};
        boolean[] aux2 = new boolean[]{true, false};

        FactoriaVampiros FV = new FactoriaVampiros();
        Terminal terminal = new Terminal();
        Vampiro vampiro = new Vampiro();
        Disciplina disciplina = new Disciplina();
        Arma arma = new Arma();
        ArrayList<Arma> armas = new ArrayList<>();
        ArrayList<Arma> armasActivas = new ArrayList<>();
        Armadura armadura = new Armadura();
        ArrayList<Armadura> armaduras = new ArrayList<>();
        Debilidad debilidad = new Debilidad();
        Fortaleza fortaleza = new Fortaleza();
        ArrayList<Debilidad> debilidades = new ArrayList<>();
        ArrayList<Fortaleza> fortalezas = new ArrayList<>();

        terminal.preguntarNombre();
        FV.inicializarNombre(vampiro);
        terminal.preguntarNombreHabilidad();
        FV.inicializarNombreHabilidad(disciplina);
        do {
            terminal.preguntarAtaqueHabilidad();
            rightValue = FV.inicializarAtaqueHabilidad(disciplina);
        } while (!rightValue);
        do {
            terminal.preguntarDefensaHabilidad();
            rightValue = FV.inicializarDefensaHabilidad(disciplina);
        } while (!rightValue);
        do {
            terminal.preguntarCosteHabilidad();
            rightValue = FV.inicializarCosteHabilidad(disciplina);
        } while (!rightValue);
        FV.setHabilidad(vampiro, disciplina);
        terminal.preguntarNumArmas();
        int numArmas = FV.askNum();
        for (int iterator = 1; iterator <= numArmas; iterator++) {
            terminal.preguntarNombreArma();
            FV.inicializarnNombreArma(arma);
            do {
                terminal.preguntarAtaqueArma();
                rightValue = FV.inicializarAtaqueArma(arma);
            } while (!rightValue);
            do {
                terminal.preguntarDefensaArma();
                rightValue = FV.inicializarDefensaArma(arma);
            } while (!rightValue);
            do {
                terminal.peguntarSingleHandArma();
                rightValue = FV.inicializarSingleHandArma(arma);
            } while (!rightValue);
            FV.addArma(armas, arma);
        }
        FV.setArmas(vampiro, armas);
        do {
            terminal.mostrarArmas(armas);
            rightWeapon = FV.addArmaActiva(arma, armas, armasActivas);
        } while (!Arrays.equals(rightWeapon, aux1) && !Arrays.equals(rightWeapon, aux2));
        if (Arrays.equals(rightWeapon, aux1)) {
            do {
                terminal.otroArma(armas);
                rightValue = FV.addArmaActiva2(arma, armas, armasActivas);
            } while (!rightValue);
        }
        FV.setArmasActivas(vampiro, armasActivas);

        terminal.preguntarNumArmaduras();
        int numArmaduras = FV.askNum();
        for (int iterator = 1; iterator <= numArmaduras; iterator++) {
            terminal.preguntarNombreArmadura();
            FV.inicializarnNombreArmadura(armadura);
            do {
                terminal.preguntarDefensaArmadura();
                rightValue = FV.inicializarDefensaArmadura(armadura);
            } while (!rightValue);
            do {
                terminal.preguntarAtaqueArmadura();
                rightValue = FV.inicializarAtaqueArmadura(arma);
            } while (!rightValue);
            FV.addArmadura(armadura, armaduras);
        }
        FV.setArmaduras(vampiro, armaduras);
        do {
            terminal.mostrarArmaduras(armaduras);
            rightValue = FV.addArmaduraActiva(vampiro, armadura, armaduras);
        } while (!rightValue);
        do {
            terminal.preguntarOro();
            rightValue = FV.inicializarOro(vampiro);
        } while (!rightValue);
        do {
            terminal.preguntarHP();
            rightValue = FV.inicializarHP(vampiro);
        } while (!rightValue);
        do {
            terminal.preguntarPoder();
            rightValue = FV.inicializarPoder(vampiro);
        } while (!rightValue);
        terminal.peguntarNumDebilidades();
        int numDebilidades = FV.askNum();
        for (int iterator = 1; iterator <= numDebilidades; iterator++) {
            terminal.preguntarNombreDebilidad();
            FV.inicializarNombreDebilidad(debilidad);
            terminal.preguntarValorDebilidad();
            FV.inicializarValorDebilidad(debilidad);
            FV.addDebilidad(debilidades, debilidad);
        }
        FV.setDebilidades(vampiro, debilidades);
        terminal.peguntarNumFortalezas();
        int numFortalezas = FV.askNum();
        for (int iterator = 1; iterator <= numFortalezas; iterator++) {
            terminal.preguntarNombreFortaleza();
            FV.inicializarNombreFortaleza(fortaleza);
            terminal.preguntarValorFortaleza();
            FV.inicializarValorFortaleza(fortaleza);
            FV.addFortaleza(fortalezas, fortaleza);
        }
        FV.setFortalezas(vampiro, fortalezas);
    }
}