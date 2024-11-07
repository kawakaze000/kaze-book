import request from '@/utils/request'

// 查询邮件日志列表
export function listEmailLog(query) {
  return request({
    url: '/system/emailLog/list',
    method: 'get',
    params: query
  })
}

// 查询邮件日志详细
export function getEmailLog(id) {
  return request({
    url: '/system/emailLog/' + id,
    method: 'get'
  })
}

// 新增邮件日志
export function addEmailLog(data) {
  return request({
    url: '/system/emailLog',
    method: 'post',
    data: data
  })
}

// 修改邮件日志
export function updateEmailLog(data) {
  return request({
    url: '/system/emailLog',
    method: 'put',
    data: data
  })
}

// 删除邮件日志
export function delEmailLog(id) {
  return request({
    url: '/system/emailLog/' + id,
    method: 'delete'
  })
}
