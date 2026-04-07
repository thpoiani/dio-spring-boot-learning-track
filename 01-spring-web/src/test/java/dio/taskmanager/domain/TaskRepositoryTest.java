package dio.taskmanager.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class TaskRepositoryTest {
    TaskRepository repository;

    protected abstract TaskRepository createRepository();

    @BeforeEach
    public void setUp() {
        this.repository = createRepository();
    }

    @Test
    void should_save_and_retrieve_task_by_id() {
        // given
        var task = new Task("Passar na padaria", Optional.empty());


        // when
        var saved = repository.save(task);
        Optional<Task> result = repository.findById(saved.getId());


        // then
        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(task.getId());
        assertThat(result.get().getDescription()).isEqualTo(task.getDescription());
        assertThat(result.get().getStatus()).isEqualTo(task.getStatus());
    }


    @Test
    void should_find_all_persisted_tasks() {
        // given
        var task1 = new Task("Arrumar chuveiro", Optional.of("Comprara chuveiro novo"));
        var task2 = new Task("Trocar interruptor", Optional.of("Encontrar chave de fenda"));


        repository.save(task1);
        repository.save(task2);


        // when
        List<Task> tasks = repository.findAll();


        // then
        assertThat(tasks).hasSize(2);
        assertThat(tasks).extracting(Task::getId).containsExactlyInAnyOrder(task1.getId(), task2.getId());
    }


    @Test
    void should_delete_task_by_id() {
        // given
        var task = repository.save(new Task("Treinar na academia", Optional.empty()));
        var taskId = task.getId();


        // when
        repository.delete(taskId);
        Optional<Task> result = repository.findById(taskId);


        // then
        assertThat(result).isEmpty();
    }


    @Test
    void should_return_empty_when_searching_non_existent_task() {
        // given
        var nonExistentId = new TaskId();


        // when
        Optional<Task> result = repository.findById(nonExistentId);


        // then
        assertThat(result).isEmpty();
    }


    @Test
    void should_update_task_status_successfully() {
        // given
        var task = repository.save(new Task("Atualizar Carteira de Habilitação", Optional.empty()));


        task.setDescription(Optional.of("Não expirou ainda"));
        task.setStatus(TaskStatus.IN_PROGRESS);


        // when
        repository.save(task);
        Optional<Task> result = repository.findById(task.getId());


        // then
        assertThat(result).isPresent();
        assertThat(result.get().getDescription()).isEqualTo(Optional.of("Não expirou ainda"));
        assertThat(result.get().getStatus()).isEqualTo(TaskStatus.IN_PROGRESS);
    }
}
