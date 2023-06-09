package hellojpa.ex1;

import javax.persistence.*;


//@SequenceGenerator(
//        name =  "member_seq_generator",
//        sequenceName = "member_seq"
//)
@Entity
@TableGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
public class Member
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE /*generator = "member_seq_generator"*/)
    private Long id;

    @Column(name = "name",nullable = false)
    private String username;

    public Member() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

