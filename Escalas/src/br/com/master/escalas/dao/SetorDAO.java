package br.com.master.escalas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.master.escalas.model.Setor;

public class SetorDAO {

	private static final String C_INSERT = "insert into ESC_SETOR (NOME) values (?)";
	private static final String R_SELECT = "select ID NOME from ESC_SETOR where ID = ?";
	private static final String U_UPDATE = "update ESC_SETOR set NOME = ? where ID = ?";
	private static final String D_REMOVE = "delete from ESC_SETOR where ID = ?";
	private static final String FIND_ALL = "select * from ESC_SETOR";

	private Connection connection;

	public SetorDAO(Connection connection) {
		this.connection = connection;
	}

	public void insert(Setor setor) {
		try (PreparedStatement pstm = this.connection.prepareStatement(C_INSERT)) {
			pstm.setString(1, setor.getDesc());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Setor select(Long id) {
		Setor setor = new Setor();
		setor.setIdS(id);
		try (PreparedStatement pstm = this.connection.prepareStatement(R_SELECT)) {
			pstm.setLong(1, setor.getIdS());
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					setor.setIdS(rs.getLong("ID"));
					setor.setDesc(rs.getString("NOME"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return setor;
	}

	public void update(Setor setor) {
		try (PreparedStatement pstm = this.connection.prepareStatement(U_UPDATE)) {
			pstm.setString(1, setor.getDesc());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Setor setor) {
		try (PreparedStatement pstm = this.connection.prepareStatement(D_REMOVE)) {
			pstm.setLong(1, setor.getIdS());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Setor> getSetores() {
		try (PreparedStatement pstm = this.connection.prepareStatement(FIND_ALL); ResultSet rs = pstm.executeQuery()) {
			List<Setor> setores = new ArrayList<Setor>();
			while (rs.next()) {
				Setor setor = new Setor();
				setor.setIdS(rs.getLong("ID"));
				setor.setDesc(rs.getString("NOME"));
				setores.add(setor);
			}
			return setores;	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
