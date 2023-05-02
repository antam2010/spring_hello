package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        repository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("testName");
        repository.save(member);
        Member result =  repository.findById(member.getId()).get();
        Assertions.assertEquals(result, member);
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
        Member member = new Member();
        member.setName("A");
        repository.save(member);

        member.setName("B");
        repository.save(member);

        Member result = repository.findByName("B").get();
        Assertions.assertEquals(member, result);
    }

    @Test
    void findAll() {
        Member member = new Member();
        member.setName("A");
        repository.save(member);

        member.setName("B");
        repository.save(member);

        List<Member> result = repository.findAll();
        Assertions.assertEquals(result.size(), 2);

    }
}