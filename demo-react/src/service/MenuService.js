import request from "../util/request";


export  function findMenuByUser(params) {
    return request.get("/menu/findMenuByUser");
}