package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain
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
            // insert
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
             //em.persist(member);

            // selcet
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember-id : " + findMember.getId());
//            System.out.println("findMember-name : " + findMember.getName());

            // Update
//            Member findMember = em.find(Member.class,1L);
//            findMember.setName("HelloJPA");

            // 쿼리 생성문
//            List<Member> result = em.createQuery("select m from Member as m ", Member.class).getResultList();
//
//            for(Member m : result)
//            {
//                System.out.println("member : " + m.getName());
//            }

            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            // 영속
////            System.out.println("--- BEFORE ----");
////            em.persist(member);
////            System.out.println("--- AFTER -----");
//
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//
////            System.out.println("findMember : " + findMember1.getId());
////            System.out.println("findMember : " + findMember1.getName());
//
//            System.out.println("findResult : " + (findMember1 == findMember2));



            //영속
//            Member m1 = new Member(150L,"a");
//            Member m2 = new Member(160L,"b");
//
//            em.persist(m1);
//            em.persist(m2);
//            System.out.println("========================");

            // 엔티티 수정 변경감지 : DB에서 값을 가져오고 변경을 하고 다시 DB에 넣어주지 않아도 된다
            // 영속성 컨텍스트에서 스냅샷 비교(1차 캐시 안에 스냅샷이 존재하는데 스냅샷이란 첫 호출을 할떄 그 값을 스냅샷으로 저장하고
            // 변경을 하고 커밋을 하는 시점에서 스냅샷으로 비교 하여 다른점을 업데이트 한다)
//            Member member = em.find(Member.class,150L);
//            member.setName("zzzz");

            // em.persist(member); // JPA에서는 값이 변경 됬어다고 해서 다시 DB에 update할 필요가 없다.



            // 엔티티 삭제
//            System.out.println("=======================");
//            Member member = em.find(Member.class, 150L);
//
//            em.remove(member);

            //flush
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//
//            em.flush();
//
//            System.out.println("==========");


            // 준영속 상태
            Member member = em.find(Member.class, 160L);
            member.setName("AAA");

            em.detach(member);

            System.out.println("=======================");



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
