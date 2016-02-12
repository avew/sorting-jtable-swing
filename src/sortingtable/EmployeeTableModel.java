/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingtable;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author avew
 */
public class EmployeeTableModel extends AbstractTableModel {
    
    private static final int COLUMN_NO = 0;
    private static final int COLUMN_NAME = 1;
    private static final int COLUMN_JOB = 2;
    private static final int COLUMN_AGE = 3;
    
    private String[] columnNames = {"No #", "Name", "Job", "Age"};
    private List<Employee> listEmployees;
    
    public EmployeeTableModel(List<Employee> listEmployees) {
        this.listEmployees = listEmployees;
        
        int indexCount = 1;
        for (Employee employee : listEmployees) {
            employee.setIndex(indexCount++);
        }
    }
    
    @Override
    public int getRowCount() {
        return listEmployees.size();
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (listEmployees.isEmpty()) {
            return Object.class;
        }
        return getValueAt(0, columnIndex).getClass();
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Employee employee = listEmployees.get(rowIndex);
        if (columnIndex == COLUMN_NO) {
            employee.setIndex((int) aValue);
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee employee = listEmployees.get(rowIndex);
        Object returnValue = null;
        
        switch (columnIndex) {
            case COLUMN_NO:
                returnValue = employee.getIndex();
                break;
            case COLUMN_NAME:
                returnValue = employee.getName();
                break;
            case COLUMN_JOB:
                returnValue = employee.getJob();
                break;
            case COLUMN_AGE:
                returnValue = employee.getAge();
                break;
            default:
                throw new IllegalArgumentException("Invalid column index");
        }
        
        return returnValue;
    }
    
}
