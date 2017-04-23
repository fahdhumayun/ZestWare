import java.awt.Dimension;
import java.awt.event.ActionEvent;
// ww  w . ja va2s  . c om
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main {
  public static void main(String[] args) {
    JScrollPane sPane = new JScrollPane();
    sPane.setPreferredSize(new Dimension(200, 150));
    JButton button = new JButton(new AbstractAction("Create Table")
    {
      public void actionPerformed(ActionEvent arg0)
      {
        DefaultTableModel model = new DefaultTableModel(new String[][]
        {
            { "Chicken", "1" }, { "Coke", "2" } }, new String[] { "Item(s)", "Quantity" });
        JTable table = new JTable(model);
        sPane.getViewport().add(table);
      }
    });
    JPanel panel = new JPanel();
    panel.add(sPane);
    panel.add(button);
    JOptionPane.showMessageDialog(null, panel);

  }
}
