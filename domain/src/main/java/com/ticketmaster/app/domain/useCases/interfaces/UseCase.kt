package com.ticketmaster.app.domain.useCases.interfaces

interface UseCase <in Params, out ResultType> where ResultType : Result {
    suspend operator fun invoke(params: Params) : ResultType
}