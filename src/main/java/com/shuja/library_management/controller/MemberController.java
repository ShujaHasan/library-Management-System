package com.shuja.library_management.controller;

import com.shuja.library_management.dto.MemberRequestDTO;
import com.shuja.library_management.dto.MemberResponseDTO;
import com.shuja.library_management.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/member")
    public MemberResponseDTO createMember(@Valid @RequestBody MemberRequestDTO memberRequestDTO){
        return memberService.createMember(memberRequestDTO);
    }

    @GetMapping("/member")
    public List<MemberResponseDTO> getAllMembers(){
        return memberService.getAllMembers();
    }

    @GetMapping("/member/{id}")
    public MemberResponseDTO getMemberById(@PathVariable Integer id){
        return memberService.getMemberById(id);
    }



}
