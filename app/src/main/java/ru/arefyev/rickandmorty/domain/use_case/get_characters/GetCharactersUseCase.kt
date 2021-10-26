package ru.arefyev.rickandmorty.domain.use_case.get_characters

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import ru.arefyev.rickandmorty.common.Resource
import ru.arefyev.rickandmorty.data.remote.dto.toCharacter
import ru.arefyev.rickandmorty.domain.model.Character
import ru.arefyev.rickandmorty.domain.repository.CharacterRepository
import java.io.IOException
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(): Flow<Resource<List<Character>?>> = flow {
        try {
            emit(Resource.Loading())
            val characters = repository.getCharacters(1).body()?.results?.map { it.toCharacter() }
            emit(Resource.Success(characters))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Непредвиденная ошибка!"))
        } catch (e: IOException) {
            emit(Resource.Error("Проблемы с сервером. Проверьте Интернет-соединение..."))
        }
    }
}