FROM node:14-alpine 
WORKDIR /app
COPY package*.json /app 
RUN npm install 
COPY . /app
CMD [ "node", "hello.js" ] 
ENV NODE_ENV test
EXPOSE 3000