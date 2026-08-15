package com.shuja.library_management.service;

import com.shuja.library_management.dto.MemberRequestDTO;
import com.shuja.library_management.dto.MemberResponseDTO;
import com.shuja.library_management.model.Member;
import com.shuja.library_management.model.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberResponseDTO createMember(MemberRequestDTO dto){
        if (memberRepository.existsByEmail(dto.getEmail())){
            throw new RuntimeException("Email already exists!");
        }
        if (memberRepository.existsByPhone(dto.getPhone())){
            throw new RuntimeException("Phone number already exists!");
        }

        Member member = new Member();

        member.setFullName(dto.getFullName());
        member.setEmail(dto.getEmail());
        member.setPhone(dto.getPhone());
        member.setAddress(dto.getAddress());

        member.setMembershipDate(LocalDate.now());

        Member savedMember = memberRepository.save(member);

        return convertToDTo(savedMember);
    }

    public List<MemberResponseDTO> getAllMembers(){
        return memberRepository.findAll()
                .stream().map(this::convertToDTo).toList();
    }

    public MemberResponseDTO getMemberById(Integer id){
        Member member = memberRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("Member not found"));

        return convertToDTo(member);
    }



    public MemberResponseDTO convertToDTo(Member member){
        return new MemberResponseDTO(
                member.getId(),
                member.getFullName(),
                member.getEmail(),
                member.getEmail(),
                member.getPhone(),
                member.getAddress(),
                member.getMembershipDate()
        );
    }











}
