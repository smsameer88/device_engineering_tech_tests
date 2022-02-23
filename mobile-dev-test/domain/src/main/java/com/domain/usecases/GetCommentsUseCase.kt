package com.domain.usecases

import com.domain.repo.INewsDataRepository
import javax.inject.Inject

class GetCommentsUseCase @Inject constructor(private val iNewsDataRepository: INewsDataRepository) {

    suspend operator fun invoke(url: String) = iNewsDataRepository.getComments(url)
}