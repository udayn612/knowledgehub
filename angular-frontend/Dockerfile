#Stage 1
FROM node:8.11.2-alpine as node
WORKDIR /usr/src/app
COPY package*.json ./
RUN npm install
RUN npm install ngx-file-drop
COPY . .
# RUN npm run build
# Stage 2
FROM node
RUN npm install http-server -g
CMD ["http-server","-p","8081", "dist/Knowledgehub"]
