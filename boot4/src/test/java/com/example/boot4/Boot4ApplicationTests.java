package com.example.boot4;

import com.example.boot4.domain.Member;
import com.example.boot4.domain.PDSBoard;
import com.example.boot4.domain.PDSFile;
import com.example.boot4.domain.Profile;
import com.example.boot4.persistence.MemberRepository;
import com.example.boot4.persistence.PDSBaordRepository;
import com.example.boot4.persistence.ProfileRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class Boot4ApplicationTests {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    PDSBaordRepository pdsBaordRepository;

    @Test
    public void testInsert(){
        IntStream.range(1,101).forEach(i->{
            Member member = new Member();
            member.setUid("user"+i);
            member.setUpw("pw"+i);
            member.setUname("사용자"+i);

            memberRepository.save(member);
        });
    }

    @Test
    public void testInsertProfile(){
        Member member = new Member();
        member.setUid("user1");

        for(int i=1;i<5;i++){
            Profile profile1 = new Profile();
            profile1.setFname("face"+i+".jpg");

            if(i==1){
                profile1.setCurrent(true);
            }

            profile1.setMember(member);
            profileRepository.save(profile1);
        }
    }

    @Test
    public void testTechJoin(){
        List<Object[]> result = memberRepository.getMemberWirthProfileCount("user1");

        result.forEach(arr-> System.out.println(Arrays.toString(arr)));
    }

    @Test
    public void testInsertPDS(){
        PDSBoard pds = new PDSBoard();
        pds.setPname("Document");

        PDSFile file1 = new PDSFile();
        file1.setPdsfile("file1.doc");

        PDSFile file2 = new PDSFile();
        file2.setPdsfile("file2.doc");

        pds.setFiles(Arrays.asList(file1,file2));

        log.info("try to save pds");

        pdsBaordRepository.save(pds);
    }

    @Transactional
    @Test
    public void testUpdateFilename(){
        Long fno = 1L;
        String newName = "updateFile1-2.doc";

        int count = pdsBaordRepository.updatePDSFile(fno, newName);
        log.info("update count: "+count);
    }

    @Transactional
    @Test
    public void testUpdateFilename2() {
        String newName = "updateFile2.doc";
        Optional<PDSBoard> result = pdsBaordRepository.findById(2L);
        result.ifPresent(pds->{
            log.info("데이터가 존재");
            PDSFile target = new PDSFile();
            target.setFno(2L);
            target.setPdsfile(newName);

            int idx = pds.getFiles().indexOf(target);

            if(idx>-1){
                List<PDSFile> list = pds.getFiles();
                list.remove(idx);
                list.add(target);
                pds.setFiles(list);
            }
            pdsBaordRepository.save(pds);
        });
    }

    @Transactional
    @Test
    public void deletePDSFIle(){
        Long fno = 2L;
        pdsBaordRepository.deletePDSFile(fno);
        log.info("dleelte!!");
    }
}
