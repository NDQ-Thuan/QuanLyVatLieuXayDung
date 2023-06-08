package customTable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class TableCustomCellRender extends DefaultTableCellRenderer {

    private final HoverIndex hoverRow;
    private final Set<Integer> redRows = new HashSet<>();
    private final Set<Integer> normalRows = new HashSet<>();
    private final Set<Integer> blueColumns = new HashSet<>();
    private final Map<Point, Color> cellColors = new HashMap<>();

    public TableCustomCellRender(HoverIndex hoverRow) {
        this.hoverRow = hoverRow;
    }

    public void setRedRow(int rowIndex) {
        redRows.add(rowIndex);
        normalRows.remove(rowIndex);
    }

    public void setNormalRow(int rowIndex) {
        normalRows.add(rowIndex);
        redRows.remove(rowIndex);
    }

    public void setBlueColumn(int columnIndex) {
        blueColumns.add(columnIndex);
    }

    public void setCellColor(int rowIndex, int columnIndex, Color color) {
        Point cell = new Point(rowIndex, columnIndex);
        cellColors.put(cell, color);
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
        } else {
            com.setForeground(table.getForeground());
        }

        // Customize the background color for the target columns
        if (blueColumns.contains(column)) {
            com.setBackground(new Color(0, 0, 153));
            com.setForeground(Color.WHITE);
            com.setFont(new Font("Arial", 1, 14));
        }

        return com;
    }
}
