# Linux 기본 명령어 정리
- ls (list) ★
    >디렉토리 목록 확인  
    리눅스나 유닉스에서는 앞에 .으로 시작하는 디렉토리는 기본적으로 숨김 파일이므로 ls 명령어로는 표시가 안된다.  
    ls -al 은 감춰진 파일 모두 -l 했을때 형식으로 나온다.

- pwd (print working directory)
    >현재 작업 중인 디렉토리 정보 출력

- cd (change directory)
    >경로 이동  
    /home/mh : 절대경로  
    cd .. : 상대경로. 부모 디렉토리로 간다. (.. 은 부모 디렉토리를 의미)

- mkdir(make directory)
    >디렉토리 생성

- rm (remove)
    >파일 삭제  
    rm -r '디렉토리 명' : 디렉토리 삭제(-는 붙으면 동작하는 방법을 바꿀때 붙이는 것)

- touch
    >빈 파일 생성 및 파일이나 디렉토리의 최근 업데이트 일자를 현재 시간으로 변경

- mv (move)
    >파일을 이동할 때 사용하거나 파일 이름을 변경할 때 사용
    파일 이동 : mv '이동할 파일이름' '이동할 곳'
    파일 이름 변경 : mv '기존 파일이름' '변경하길 원하는 이름'

- sudo (super user do)
    >permission super user or root user.
    sudo를 붙이면 super user의 권한으로 명령어를 실행한다.

- linux 설명 출력
    >'명령어' --help : 기존 화면에서 벗어나지 않는 한에서 설명 출력  
    man '명령어' : 상세한 설명 페이지로 이동  
    /를 누르고 원하는 단어를 쓰고 엔터를 누르면 그 단어를 검색할 수 있다.(ctrl + 'f'기능) 이 상태에서 n을 누르면 다음 단어로 이동. q를 누르면 밖으로 빠져나올 수 있음

- file edit (nano / vi 가 있는데 nano로 실습함. nano가 익숙해지면 vi사용하는 것을 추천함)
    >nano를 입력하면 file edit창이 뜨는데 밑의 설명 보고 사용하면 된다. ^는 ctrl을 의미함. 여러 단어 선택하고 싶을 땐 ctrl + '6'

- Package Manager(앱스토어같이 package를 다운받아 사용할 수 있는 것)
    >2종류가 있다 -> apt, yum
    - package 목록 다운 : sudo apt-get update;
    - 검색 : sudo apt-cache search '검색어'
    - 다운로드 : sudo apt-get install '다운할 프로그램 이름'
    - 업그레이드 : sudo apt-get upgrade (다운되어있는 모든 프로그램 업데이트, 프로그램 이름 붙이면 그 프로그램만 업데이트 가능)
    - 삭제 : sudo apt-get remove '삭제할 프로그램 이름'