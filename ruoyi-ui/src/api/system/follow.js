import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listFollow(query) {
  return request({
    url: '/system/follow/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getFollow(id) {
  return request({
    url: '/system/follow/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addFollow(data) {
  return request({
    url: '/system/follow',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateFollow(data) {
  return request({
    url: '/system/follow',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delFollow(id) {
  return request({
    url: '/system/follow/' + id,
    method: 'delete'
  })
}
