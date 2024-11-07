import request from '@/utils/request'

// 查询账户明细列表
export function listFinancialRecords(query) {
  return request({
    url: '/system/financialRecords/list',
    method: 'get',
    params: query
  })
}

// 查询账户明细详细
export function getFinancialRecords(id) {
  return request({
    url: '/system/financialRecords/' + id,
    method: 'get'
  })
}

// 新增账户明细
export function addFinancialRecords(data) {
  return request({
    url: '/system/financialRecords',
    method: 'post',
    data: data
  })
}

// 修改账户明细
export function updateFinancialRecords(data) {
  return request({
    url: '/system/financialRecords',
    method: 'put',
    data: data
  })
}

// 删除账户明细
export function delFinancialRecords(id) {
  return request({
    url: '/system/financialRecords/' + id,
    method: 'delete'
  })
}
