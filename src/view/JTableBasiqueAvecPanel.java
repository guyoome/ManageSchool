/**
 * contient la présentation de l'interface graphique
 */
package view;

import javax.swing.*;
import java.awt.*;

/**
 * classe qui créer des jTable avec Panel
 * @author clara, guillaume
 */
public class JTableBasiqueAvecPanel extends JFrame{
    /**
     * contructeur par default
     */
    public JTableBasiqueAvecPanel() {
        super();

        setTitle("JTable basique dans un JPanel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Object[][] donnees = {
                {"Johnathan", "Sykes", Color.red, true,"TENNIS"},
                {"Nicolas", "Van de Kampf", Color.black, true, "FOOT"},
                {"Damien", "Cuthbert", Color.cyan, true, "RIEN"},
                {"Corinne", "Valance", Color.blue, false, "NATATION"},
                {"Emilie", "Schrödinger", Color.magenta, false, "FOOT"},
                {"Delphine", "Duke", Color.yellow, false, "TENNIS"},
                {"Eric", "Trump", Color.pink, true, "FOOT"},
        };

        String[] entetes = {"Prénom", "Nom", "Couleur favorite", "Homme", "Sport"};

        JTable tableau = new JTable(donnees, entetes);

        getContentPane().add(tableau.getTableHeader(), BorderLayout.CENTER);
        /*getContentPane().add(tableau, BorderLayout.CENTER);*/

        pack();
    }
    /**
     * main
     * @param args 
     */
    public static void main(String[] args) {
        new JTableBasiqueAvecPanel().setVisible(true);
    }
}
