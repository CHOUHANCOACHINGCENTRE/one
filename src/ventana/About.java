/**
 * <p>Title: Algoritmo Kuhn-Munkres</p>
 *
 * <p>Description: es un algoritmo de optimización el cual resuelve problemas 
 * de asignación. La primera versión conocida del método Húngaro, fue inventado
 * y publicado por Harold Kuhn en 1955. Este fue revisado por James Munkres en 
 * 1957, y ha sido conocido desde entonces como el algoritmo Húngaro, 
 * el algoritmo de asignamiento de Munkres, o el algoritmo de Kuhn-Munkres.
 * 
 * El algoritmo desarrollado por Kuhn está basado fundamentalmente en los 
 * primeros trabajos de otros dos matemáticos Húngaros: Dénes König y 
 * Jenő Egerváry. La gran ventaja del método de Kuhn es que es fuertemente 
 * polinómico (ver Complejidad computacional para más detalles).
 * 
 * El algoritmo construye una solución del problema primal partiendo de una 
 * solución no admisible (que corresponde a una solución admisible del dual) 
 * haciéndola poco a poco más admisible.</p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * @author Gustavo Bazan, Armando Bracho, Juan Sandomingo & Carlos Proano
 *
 * @version 1.0
 */

package ventana;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**About dialogo sobre la aplicacion*/
public class About extends JDialog {

    /**
     * Creates new form About
     */
    public About(JFrame parent) {
        super(parent,true);
        initComponents();
        pack();
        Rectangle parentBounds = parent.getBounds();
        Dimension size = getSize();
        // Center in the parent
        int x = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int y = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        setLocation(new Point(x, y));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        copyrightTextArea = new javax.swing.JTextArea();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About Kuhn-Munkres");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(11, 11, 12, 12));
        mainPanel.setLayout(new java.awt.GridBagLayout());

        copyrightTextArea.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        copyrightTextArea.setColumns(25);
        copyrightTextArea.setEditable(false);
        copyrightTextArea.setLineWrap(true);
        copyrightTextArea.setRows(8);
        copyrightTextArea.setText("Problemas de Asignacion. Algoritmo Kuhn-Munkres\n\t\n    Copyright (c) 2008  Gustavo Bazán, Armando Bracho, Juan Sandomingo & Carlos Proaño.");
        copyrightTextArea.setWrapStyleWord(true);
        copyrightTextArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        copyrightTextArea.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(24, 0, 24, 0);
        mainPanel.add(copyrightTextArea, gridBagConstraints);

        closeButton.setMnemonic('C');
        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        mainPanel.add(closeButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(mainPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    /**Salir*/
    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JTextArea copyrightTextArea;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables

}
