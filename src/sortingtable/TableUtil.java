/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingtable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.RowSorterEvent;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author avew
 */
public class TableUtil {

    /**
     * Sorting table
     *
     * @param jTable
     * @param tableModel
     * @param columIndex
     */
    public static void sorting(JTable jTable, TableModel tableModel, List<Integer> columIndex) {
        jTable.setModel(tableModel);

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable.getModel());
        jTable.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();

        columIndex.stream().forEach((columIndex1) -> {
            sortKeys.add(new RowSorter.SortKey(columIndex1, SortOrder.ASCENDING));
        });

        sorter.setSortKeys(sortKeys);
        sorter.sort();

        sorter.addRowSorterListener((RowSorterEvent e) -> {
            int indexOfNoColumn = 0;
            for (int i = 0; i < jTable.getRowCount(); i++) {
                jTable.setValueAt(i + 1, i, indexOfNoColumn);
            }
        });
    }

}
