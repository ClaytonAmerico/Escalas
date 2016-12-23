package br.com.master.escalas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.master.escalas.model.EscalaDomingo;

public class EscalaDomingoDAO {
	
	private static final String C_INSERT = "insert into ESC_DOMINGO (MES, ANO, COD_FUN, ID_HORA, ID_SETOR) values (?, ?, ?, ?, ?)";
	private static final String R_SELECT = "select * from ESC_DOMINGO where MES = ? and ANO = ?";
	private static final String U_UPDATE = "update ESC_DOMINGO set MES = ? ANO = ?, COD_FUN = ?, ID_HORA = ?, ID_SETOR = ? where ID = ?";
	private static final String D_REMOVE = "delete from ESC_DOMINGO where MES = ? and ANO = ?";
	
	private Connection connection;
	
	public EscalaDomingoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(EscalaDomingo escalaDomingo) {
		try (PreparedStatement pstm = this.connection.prepareStatement(C_INSERT)) {
			pstm.setInt(1, escalaDomingo.getMes());
			pstm.setInt(2, escalaDomingo.getAno());
			pstm.setLong(3, escalaDomingo.getIdF());
			pstm.setLong(4, escalaDomingo.getIdH());
			pstm.setLong(5, escalaDomingo.getIdS());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<EscalaDomingo> getHorarios(int mes, int ano) {
		try (PreparedStatement pstm = this.connection.prepareStatement(R_SELECT); ResultSet rs = pstm.executeQuery()) {
			pstm.setInt(1, mes);
			pstm.setInt(2, ano);
			List<EscalaDomingo> escalaDomingos = new ArrayList<EscalaDomingo>();
			while(rs.next()){
				EscalaDomingo escalaDomingo = new EscalaDomingo();
				escalaDomingo.setMes(rs.getInt("MES"));
				escalaDomingo.setAno(rs.getInt("ANO"));
				escalaDomingo.setIdF(rs.getLong("COD_FUN"));
				escalaDomingo.setIdH(rs.getLong("ID_HORA"));
				escalaDomingo.setIdS(rs.getLong("ID_SETOR"));
				escalaDomingos.add(escalaDomingo);
			}
			return escalaDomingos;			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(EscalaDomingo escalaDomingo) {
		try (PreparedStatement pstm = this.connection.prepareStatement(U_UPDATE)) {
			pstm.setInt(1, escalaDomingo.getMes());
			pstm.setInt(2, escalaDomingo.getAno());
			pstm.setLong(3, escalaDomingo.getIdF());
			pstm.setLong(4, escalaDomingo.getIdH());
			pstm.setLong(5, escalaDomingo.getIdS());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(EscalaDomingo escalaDomingo) {
		try (PreparedStatement pstm = this.connection.prepareStatement(D_REMOVE)) {
			pstm.setInt(1, escalaDomingo.getMes());
			pstm.setInt(2, escalaDomingo.getAno());
			pstm.execute();			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
