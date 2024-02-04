- 형태
![ima.png](img.png)

- 장점
  - 공통 로직을 Front controller 에서 처리 가능하게 됨 
    - MyView 객체의 render() 를 호출하는 부분을 모두 일관되게 처리 가능


- 단점 
  - 아직도 path 중복 
  - inner controller 는 아직도 request 와 response 를 다 가지고 있어야. 