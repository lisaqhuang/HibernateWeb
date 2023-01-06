package tw.hibernatedemo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="books")
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="booktitle")
	private String booktitle;
	
	@Column(name="publicYear")
	private String publicYear;

	@Column(name="fk_user_id")
	@Transient
	private int userid;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_user_id")
	private BookUsers bookuser;
	
	public Books() {
			
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getPublicYear() {
		return publicYear;
	}

	public void setPublicYear(String publicYear) {
		this.publicYear = publicYear;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public BookUsers getBookusers() {
		return bookuser;
	}

	public void setBookusers(BookUsers bookuser) {
		this.bookuser = bookuser;
	}

	
}
