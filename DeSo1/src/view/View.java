/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jocelyn
 */
public interface View {
    <T> void showData(List<T> l, DefaultTableModel model);
}
