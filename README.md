# AWS Copilot
- https://aws.github.io/copilot-cli/docs/getting-started/first-app-tutorial/
- https://github.com/aws/copilot-cli

# How to install Copilot
- [맥OS]
> $ brew install aws/tap/copilot-cli
- [윈도우]
> Invoke-WebRequest -OutFile 'C:\Program Files\copilot.exe' https://github.com/aws/copilot-cli/releases/latest/download/copilot-windows.exe

# Deploy App
### copilot init으로 대화형식으로 처음엔 bootstrapping하는게 좋음
- 자동생성되는 Assets: 
1. root/copilot폴더, 그 아래 service별 manifest파일 (like k8s Deployment menifest yaml file)
2. root/copilot/.workspace파일 (copilot프로젝트이며 어떤 app이란걸 명시)
copilot pipline init명령어후엔, buildspec.yml/pipline.yml파일 자동생성됨

### 물론, 처음부터 copilot init이 싫다면 아래와 같이 step by step으로 생성해도 무관
> Create the app and env first.
1. copilot app init -n copilot-demo
2. copilot env init -n test
> Create the frontend service.
3. copilot svc init -n copilot-frontend
4. copilot svc deploy -n copilot-frontend
> Create the backend service.
5. copilot svc init -n copilot-backend
6. copilot svc deploy -n copilot-backend

> Add env (PROD): copilot env init

> Cretae pipeline: copilot pipeline init

### To deploy this app, clone this repo and then run:

> (e.g.)
>
> $ copilot init --app demo \
>  --name api \
>  --type "Load Balanced Web Service" \
>  --dockerfile "./Dockerfile" \
>  --deploy

## Copilot will set up the following resources in your account:
- A VPC
- Subnets/Security Groups
- Application Load Balancer
- Amazon ECR Repositories
- ECS Cluster & Service running on AWS Fargate

# CI/CD Pipeline auto-creation

$ copilot pipeline init

$ git add copilot/pipeline.yml copilot/buildspec.yml copilot/.workspace && git commit -m "Adding pipeline artifacts" && git push

$ copilot pipeline update

- 최초 생성되는 pipeline.yml파일내의 branch명은 default: main 브랜치로 되어있으므로 본인 환경에서 master를 사용시 변경필요

# Cleaning up
Since this demo sets up resources in your account, let's delete them so you don't get charged:

$ copilot app delete

---
### 현재는 backend service로 배포해도 default로는 private subnet에 task(pod)들을 생성하지 않음.
서브넷속성에 MapPublicIpOnLaunch: false 를 해주지 않으면 public ip가 자동으로 생성되어 버리므로 (현재는 무조건 생성하도록 되어있는듯)

참고: https://github.com/aws/copilot-cli/discussions/2378


