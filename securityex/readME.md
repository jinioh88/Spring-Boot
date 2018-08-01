# 스프링 시큐리티
## 시큐리티 설정
  - @EnableWebSecurity : 작성된 시큐리티 클래스가 빈에 등록되도록 설정.
  - 시큐리티 설정을 담당하는 WebSecurityConfigurerAdapter 클래스
  - 만약 SecurityConfig를 생성하지 안핬다면 시큐리티는 모든 URI에 대한 인증을 요구한다. 
  - 웹상 시큐리티를 적용하기 위해 컨트롤러와 화면을 생성해 보자
    - controller 패키지에 SamplleContrller 작성.
    - 권한 별 html 페이지 생성

## 회원 권한 설계
  - 회원에 대한 용어는 Member로 했다. User는 시큐리티에서 사용하고 있기 때문...
  - Member에 등급 이나 권한을 갖도록 설계 하자. MemberRole을 갖도록하고 특정 URL에서 이를 체크하도록 하자.
  
## 단순 시큐리티 적용
  - 웨에서 스프링 시큐리티는 필터 기반으로 동작한다. 
  - 로그인/로그아웃 관련 처리
    - 특정 경로에 대해 인가를 하고 로그인, 로그아웃 처리를 해 보자.
    - HttpSecurity는 웹과 관련된 다양한 보안 설정을 걸어 줄 수 있다. 
        - authorizeRequests(), antMatches()로 특정 경로에 특정 권한을 가진 사람만 접근할 수 있게 한다.
        - antMatches()로 특정 경로를 지정하고, permitAll()은 모든사용자 접근, hasRole()로 특정 권한 가진 사람만 접근할 수 있게 설정하자.
    - 로그인 페이지 보이기
        - 인가 받은 권한 없으면 /login 경로로 로그인하도록 하자.
        - http.formLogin() 이 함수로 별도의 로그인 페이지 없이 로그이 할 수 있게 할 수 있다. 
    - 로그린 관련정보 삭제
        - 웹 관련 로그인 정보는 HttpSession을 이용한다. 
        - 세션쿠키 삭제로 로그인 정보를 삭제한다. 
  - 커스텀 페이지를 만들자
    - 스프링 시큐리티 기본 폼 말고 formLogin() 이후에 loginPage() 메소드를 이용해 URI를 지정해 커스텀 페이지를 보이자.
    - 페이지 권한 실패시 http.exceptionHandling().accessDeniedPage("/accessDenied"); 로 예외를 주자.
  - 로그아웃 처리하기
    - http.logout().logoutUrl("/logout").invalidateHttpSession(true); 로 HttpSession 정보를 무효화 한다.
    

## 단순 인증
  - 외부에서 인증이 필요하다고 판단 되는 경우 인증에 대한 실제적 처리를 담당하는 인증 매니저 이다.
  - 인증 매니저는 인증과 관련된 모든 정보를 UserDetails라는 타입으로 반환한다. 
  - 이를 위해서 어떻게 관련 정보를 처리할지 판달할 UserDetailsService 존재를 활용하자. 
  - AuthenticationManagerBuilder는 여러 종류의 인증 매니저들을 생성할 수 있다. 
  - 인증 매니저를 이용해 인증 작업이 수행 된다.
  - 인증 매니저들은 인증/인가를 위한 UserDetailsService를 통해 필요한 정보를 가져온다.
  - UserDetails는 사용자의 정보+권한 정보들의 묶음이 들어있다. 

