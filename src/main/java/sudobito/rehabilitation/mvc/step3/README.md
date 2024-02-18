- 형태
![img.png](img.png)

- 장점
  - 컨트롤러에서, HttpServletRequest,Response 의 존재 모름 
    - 서블릿 기술과 독립적
  - viewResolver 존재 
    - 뷰의 논리 이름만 반환하면 됨 

- 단점 
  -  항상 controller에서,ModelView 객체를 생성 &반환하는 부분이 번거로움