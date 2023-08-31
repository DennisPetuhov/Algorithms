//package com.example.algorithms.CleanCodeUncleBobBook
//
//abstract class Employee {
//    abstract val isPayday: Boolean
//    abstract fun calculatePay(): Int?
//    abstract fun deliverPay(pay: Int?)
//}
//
//interface EmployeeFactory {
//    @Throws(InvalidEmployeeType::class)
//    fun makeEmployee(r: EmployeeRecord): Employee
//}
//
//class EmployeeFactoryImpl : EmployeeFactory {
//    @Throws(InvalidEmployeeType::class)
//    override fun makeEmployee(r: EmployeeRecord): Employee {
//        return when (r.type) {
//            COMMISSIONED -> CommissionedEmployee(r)
//            HOURLY -> HourlyEmployee(r)
//            SALARIED -> SalariedEmploye(r)
//            else -> throw InvalidEmployeeType(r.type)
//        }
//    }
//}


