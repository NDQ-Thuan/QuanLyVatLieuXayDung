package customTable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class TableCustomCellRender extends DefaultTableCellRenderer {

    private final HoverIndex hoverRow;
    private final Set<Integer> redRows = new HashSet<>();
    private final Set<Integer> blueRows = new HashSet<>();

    public TableCustomCellRender(HoverIndex hoverRow) {
        this.hoverRow = hoverRow;
    }

    public void setRedRow(int rowIndex) {
        redRows.add(rowIndex);
        blueRows.remove(rowIndex);
    }

    public void setBlueRow(int rowIndex) {
        blueRows.add(rowIndex);
        redRows.remove(rowIndex);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        if (isSelected) {
            com.setBackground(table.getSelectionBackground());
        } else {
            if (row == hoverRow.getIndex()) {
                com.setBackground(new Color(230, 230, 230));
            } else {
                if (row % 2 == 0) {
                    com.setBackground(Color.WHITE);
                } else {
                    com.setBackground(new Color(242, 242, 242));
                }
            }
        }

        // Customize the foreground color for the target rows
        if (redRows.contains(row)) {
            com.setForeground(Color.RED);
            com.setFont(new Font("Arial", 1, 12));
        } else if (blueRows.contains(row)) {
            com.setForeground(Color.BLUE);
            com.setFont(new Font("Arial", 1, 12));
        } else {
            com.setForeground(table.getForeground());
        }

        return com;
    }
}
