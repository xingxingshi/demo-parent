import request from "../util/request";


export async function findUserById(params) {
    return request('/user/findUserById', {
        method: 'get',
        data:params
    })
}