package com.blog.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.blog.Idao.IDianZanDao;
import com.blog.bean.DianZan;
import com.blog.util.DBUtil;

public class DianZanDao implements IDianZanDao {
	ResultSet rs=null;
	
	public  int getTotalCount() {//查询总数据量
		String sql = "SELECT COUNT(*) FROM dianzan WHERE is_used=true;" ;
		return DBUtil.getTotalCount(sql);
	}
	public boolean insertDianZan(DianZan dianzan){
		String sql="insert into `weblog`.`dianzan` (`dz_album`, `dz_user`) values (?,?)";
		Object[] params={dianzan.getDz_album(),dianzan.getDz_user()};
	    return  DBUtil.executeUpdate(sql, params); 
	}
	public boolean is_usedDianZan(DianZan dianzan){
		String sql="update `weblog`.`dianzan` set `is_used` = ? where `dz_id` = ?";
		Object[] params={dianzan.isIs_used(),dianzan.getDz_id()};
	    return  DBUtil.executeUpdate(sql, params); 
	}
	public DianZan dianzan(int u_id,int dz_album){
		DianZan dianzan=null;
		String sql = "SELECT * FROM dianzan WHERE  dz_user=? and dz_album=?;" ;
		Object[] params={u_id,dz_album};
	    rs = DBUtil.getResulSet(sql, params);
	    try {
				if(rs.next()){
					 int dz_id = rs.getInt("dz_id");
					 int dz_user = rs.getInt("dz_user");
					 Timestamp createtime = rs.getTimestamp("createtime");
					 boolean is_used = rs.getBoolean("is_used");
					 dianzan=new DianZan();
					 dianzan.setDz_id(dz_id);
					 dianzan.setDz_album(dz_album);
					 dianzan.setDz_user(dz_user);
					 dianzan.setIs_used(is_used);
					 dianzan.setCreatetime(createtime);
					
				}
			return dianzan;
		    } catch (SQLException e) {
				e.printStackTrace();
				return null;
			}finally{
		    	DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
		    }
	}
	
}
