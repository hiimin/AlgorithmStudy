# dao, dto

## DAO란

Data Access Object의 약자로 Database의 data에 접근을 위한 객체이다. Database에 접근을 하기위한 로직과 비즈니스 로직을 분리하기 위해서 사용한다. 쉽게 말해 데이터베이스에 접속해서 데이터 검색, 추가, 삭제, 수정 등의 작업을 하는 클래스

### example

```java
package pknu.it;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<MemberDTO> getAllData(){
		ArrayList<MemberDTO> list = new ArrayList();
		
		Connection connect = null;
		Statement state = null;
		ResultSet result = null;
		
		try {
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "test");
			state = connect.createStatement();
			result = state.executeQuery("select * from member");
			
			while(result.next()) {
				int mno = result.getInt("mno");
				String mid = result.getString("mid");
				String mpass = result.getString("mpass");
				String mclass = result.getString("mclass");
				
				list.add(new MemberDTO(mno, mid, mpass, mclass));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(connect!=null)connect.close();
				if(state!=null)state.close();
				if(result!=null)result.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return list;
	}
}

```

## DTO란

DTO\(Data Transfer Object\)는 VO\(Value Object\)로 바꿔 말할 수 있는데 계층간 데이터 교환을 위한 자바빈즈를 말한다. 일반적인 DTO는 로직을 갖고 있지 않는 순수한 데이터 객체이며 속성과 그 속성에 접근하기 위한 getter, setter 메소드만 가진 클래스이다. Database에서 데이터를 관리할 때 데이터를 일반적인 변수에 할당하여 작업 할 수도 있지만 해당 데이터의 클래스\(DTO\)를 만들어서 사용한다.

### example

```java
package pknu.it;

public class MemberDTO {
	int mno;
	String mid;
	String mpass;
	String mclass;
	
	public MemberDTO(int mno, String mid, String mpass, String mclass) {
		this.setMno(mno);
		this.setMid(mid);
		this.setMpass(mpass);
		this.setMclass(mclass);
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "MemberDTO [mno=" + mno + ", mid=" + mid + ", mpass=" + mpass + ", mclass=" + mclass + "]";
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public void setMpass(String mpass) {
		this.mpass = mpass;
	}

	public void setMclass(String mclass) {
		this.mclass = mclass;
	}
}

```

