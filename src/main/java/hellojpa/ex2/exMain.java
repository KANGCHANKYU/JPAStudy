package hellojpa.ex2;

import hellojpa.ex1.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class exMain
{
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        // code
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try
        {
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            User user = new User();
//            user.setName("member1");
//            user.setTeamId(team.getId());
//            em.persist(user);
//
//            User findMember = em.find(User.class, user.getId());
//
//            Long findTeamId = findMember.getTeamId();
//            Team findTeam = em.find(Team.class, findTeamId);

//            // 저장하는 코드
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            User user = new User();
//            user.setName("member1");
//            user.setTeam(team);
//            em.persist(user);
//
//            em.flush();
//            em.clear();
//
//            User findMember = em.find(User.class, user.getId());
//
//            Team findTeam = findMember.getTeam();
//            System.out.println("findTeamMember : " + findTeam);
//
////            // 수정할때를 위한 가정 사황
////            Team newTeam = em.find(Team.class, 100L);
////            findMember.setTeam(newTeam);
            /* 여기 까지 단방향 밑부터 양방향 */

//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            User user = new User();
//            user.setName("member1");
//            user.setTeam(team);
//            em.persist(user);
//
//            em.flush();
//            em.clear();
//
////            User findUser = em.find(User.class, user.getId());
////            List<User> members = findUser.getTeam().getUsers();
////
////            for(User u : members)
////            {
////                System.out.println("u = " + u.getName());
////            }

            
            // 연관 관계의 주인 테이블 끼리의 봤을때 m인 부분이 연관 관계에 주인이다 그래도 양쪽에 값을 셋팅 해줘야됀다
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            User user = new User();
            user.setName("member1");
            //user.changTeam(team);
            em.persist(user);

            team.addUser(user);

            em.flush();
            em.clear();

            Team team1 = em.find(Team.class, team.getId());
            List<User> users = team1.getUsers();

            for(User u : users)
            {
                System.out.println("users : " + u);
            }

            tx.commit();
        }
        catch (Exception e)
        {
            tx.rollback();
        }
        finally
        {
            em.close();
        }

        emf.close();
    }
}
