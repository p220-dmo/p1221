package fr.htc.file.load.dao;

import java.sql.SQLException;

import fr.htc.file.load.data.Sale;
import fr.htc.file.load.utils.DataBaseUtils;

public class SaleDao {

	public boolean save(Sale sale) {
		try {
			int status = DataBaseUtils.getConnection().createStatement().executeUpdate(sale.getAsInsertStatement());
			if (status != 0) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erreur de connection à la base : " + e);
		}
		return false;
	}

}
