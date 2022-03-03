 package ecommercGesture;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import ecommercGesture.application.memberQueriesCommandsEvents.commands.AddScheduledPayment;
import ecommercGesture.application.memberQueriesCommandsEvents.commands.AddScheduledPaymentCommandHandler;
import ecommercGesture.application.memberQueriesCommandsEvents.commands.MembershipApply;
import ecommercGesture.application.memberQueriesCommandsEvents.commands.MembershipApplyCommandHandler;
import ecommercGesture.application.memberQueriesCommandsEvents.commands.MembershipRenew;
import ecommercGesture.application.memberQueriesCommandsEvents.commands.MembershipRenewCommandHandler;
import ecommercGesture.application.memberQueriesCommandsEvents.commands.StopAutomaticRenew;
import ecommercGesture.application.memberQueriesCommandsEvents.commands.StopAutomaticRenewCommandHandler;
import ecommercGesture.application.memberQueriesCommandsEvents.queries.RetrieveMembershipById;
import ecommercGesture.application.memberQueriesCommandsEvents.queries.RetrieveMembershipByIdHandler;
import ecommercGesture.application.memberQueriesCommandsEvents.queries.RetrieveMemberships;
import ecommercGesture.application.memberQueriesCommandsEvents.queries.RetrieveMembershipsHandler;
import ecommercGesture.application.memberQueriesCommandsEvents.queries.RetrieveScheduledPaymentById;
import ecommercGesture.application.memberQueriesCommandsEvents.queries.RetrieveScheduledPaymentByIdHandler;
import ecommercGesture.application.memberQueriesCommandsEvents.queries.RetrieveScheduledPayments;
import ecommercGesture.application.memberQueriesCommandsEvents.queries.RetrieveScheduledPaymentsHandler;
import ecommercGesture.application.projectQueriesCommandsEvent.commands.AddProjectWorker;
import ecommercGesture.application.projectQueriesCommandsEvent.commands.AddProjectWorkerCommandHandler;
import ecommercGesture.application.projectQueriesCommandsEvent.commands.CloseProject;
import ecommercGesture.application.projectQueriesCommandsEvent.commands.CloseProjectCommandeHandler;
import ecommercGesture.application.projectQueriesCommandsEvent.commands.CreateProject;
import ecommercGesture.application.projectQueriesCommandsEvent.commands.CreateProjectCommandeHandler;
import ecommercGesture.application.projectQueriesCommandsEvent.commands.ModifyProject;
import ecommercGesture.application.projectQueriesCommandsEvent.commands.ModifyProjectCommandHandler;
import ecommercGesture.application.projectQueriesCommandsEvent.commands.RemoveProjectWorker;
import ecommercGesture.application.projectQueriesCommandsEvent.commands.RemoveProjectWorkerCommandeHandler;
import ecommercGesture.application.projectQueriesCommandsEvent.queries.RetrieveProjectById;
import ecommercGesture.application.projectQueriesCommandsEvent.queries.RetrieveProjectByIdHandler;
import ecommercGesture.application.projectQueriesCommandsEvent.queries.RetrieveProjects;
import ecommercGesture.application.projectQueriesCommandsEvent.queries.RetrieveProjectsByManagerId;
import ecommercGesture.application.projectQueriesCommandsEvent.queries.RetrieveProjectsByManagerIdHandler;
import ecommercGesture.application.projectQueriesCommandsEvent.queries.RetrieveProjectsHandler;
import ecommercGesture.application.userQueriesCommandsEvents.commands.CreateUser;
import ecommercGesture.application.userQueriesCommandsEvents.commands.CreateUserCommandHandler;
import ecommercGesture.application.userQueriesCommandsEvents.commands.ModifyUserPassword;
import ecommercGesture.application.userQueriesCommandsEvents.commands.ModifyUserPasswordCommandHandler;
import ecommercGesture.application.userQueriesCommandsEvents.commands.ModifyUserUserName;
import ecommercGesture.application.userQueriesCommandsEvents.commands.ModifyUserUserNameCommandHandler;
import ecommercGesture.application.userQueriesCommandsEvents.events.CreateUserEvent;
import ecommercGesture.application.userQueriesCommandsEvents.events.CreateUserEventListener;
import ecommercGesture.application.userQueriesCommandsEvents.queries.RetrieveUserById;
import ecommercGesture.application.userQueriesCommandsEvents.queries.RetrieveUserByIdHandler;
import ecommercGesture.application.userQueriesCommandsEvents.queries.RetrieveUsers;
import ecommercGesture.application.userQueriesCommandsEvents.queries.RetrieveUsersHandler;
import ecommercGesture.domain.services.BillingInformationService;
import ecommercGesture.domain.services.ExternalPaymentService;
import ecommercGesture.domain.services.GlobalPaymentService;
import ecommercGesture.domain.services.MembershipService;
import ecommercGesture.domain.services.MembershipApplicationService;
import ecommercGesture.domain.services.PaymentService;
import ecommercGesture.domain.services.ProjectCreationModificationService;
import ecommercGesture.domain.services.ProjectService;
import ecommercGesture.domain.services.ScheduledPaymentService;
import ecommercGesture.domain.services.UserService;
import ecommercGesture.infrastructure.defaultRepositoryImplementation.InMemoryBillingInformationRepository;
import ecommercGesture.infrastructure.defaultRepositoryImplementation.InMemoryMembershipRepository;
import ecommercGesture.infrastructure.defaultRepositoryImplementation.InMemoryPaymentRepository;
import ecommercGesture.infrastructure.defaultRepositoryImplementation.InMemoryProjectRepository;
import ecommercGesture.infrastructure.defaultRepositoryImplementation.InMemoryScheduledPaymentRepository;
import ecommercGesture.infrastructure.defaultRepositoryImplementation.InMemoryUserRepository;
import kernel.Command;
import kernel.CommandBus;
import kernel.CommandHandler;
import kernel.DefaultEventDispatcher;
import kernel.Event;
import kernel.EventDispatcher;
import kernel.EventListener;
import kernel.Query;
import kernel.QueryBus;
import kernel.QueryHandler;
import kernel.SimpleCommandBus;
import kernel.SimpleQueryBus;

@Configuration
@EnableScheduling
public class UserConfiguration {
	
    @Bean
    public UserService userService() {
        return new UserService(new InMemoryUserRepository());
    }
    
    @Bean
    public MembershipService memberService() {
        return new MembershipService(new InMemoryMembershipRepository());
    }
    
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(new InMemoryPaymentRepository());
    }
    
    @Bean
    public ProjectService projectService() {
        return new ProjectService(new InMemoryProjectRepository());
    }
    
    @Bean
    public ScheduledPaymentService scheduledPaymentService() {
        return new ScheduledPaymentService(new InMemoryScheduledPaymentRepository());
    }
    
    @Bean
    public ExternalPaymentService externalPaymentService() {
        return new ExternalPaymentService();
    }
    
    @Bean
    public BillingInformationService billingInformationService() {
        return new BillingInformationService(new InMemoryBillingInformationRepository());
    }
    
    @Bean
    public GlobalPaymentService globalPaymentService() {
        return new GlobalPaymentService(paymentService(),externalPaymentService(),scheduledPaymentService());
    }
    
    @Bean
    public MembershipApplicationService membershipApplicationService() {
        return new MembershipApplicationService(userService(),memberService(),globalPaymentService(), billingInformationService());
    }
    
    @Bean
    public ProjectCreationModificationService projectCreationModificationService() {
        return new ProjectCreationModificationService(userService(),memberService(),projectService());
    }
    
    @Bean
    public EventDispatcher<Event> eventEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(CreateUserEvent.class, List.of(new CreateUserEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }  

    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(CreateUser.class, new CreateUserCommandHandler(userService(),eventEventDispatcher()));
        commandHandlerMap.put(ModifyUserUserName.class, new ModifyUserUserNameCommandHandler(userService(),eventEventDispatcher()));
        commandHandlerMap.put(ModifyUserPassword.class, new ModifyUserPasswordCommandHandler(userService(),eventEventDispatcher()));
        commandHandlerMap.put(MembershipApply.class, new MembershipApplyCommandHandler(membershipApplicationService(),billingInformationService() ,eventEventDispatcher()));
        commandHandlerMap.put(MembershipRenew.class, new MembershipRenewCommandHandler(membershipApplicationService(),eventEventDispatcher()));
        commandHandlerMap.put(StopAutomaticRenew.class, new StopAutomaticRenewCommandHandler(membershipApplicationService(),eventEventDispatcher()));
        commandHandlerMap.put(AddProjectWorker.class, new AddProjectWorkerCommandHandler(projectCreationModificationService(),eventEventDispatcher()));
        commandHandlerMap.put(CreateProject.class, new CreateProjectCommandeHandler(projectCreationModificationService(),projectService(),eventEventDispatcher()));
        commandHandlerMap.put(ModifyProject.class, new ModifyProjectCommandHandler(projectCreationModificationService(),projectService(),eventEventDispatcher()));
        commandHandlerMap.put(RemoveProjectWorker.class, new RemoveProjectWorkerCommandeHandler(projectCreationModificationService(),eventEventDispatcher()));
        commandHandlerMap.put(AddScheduledPayment.class, new AddScheduledPaymentCommandHandler(globalPaymentService(),billingInformationService(),eventEventDispatcher()));
        commandHandlerMap.put(CloseProject.class, new CloseProjectCommandeHandler(projectCreationModificationService(),eventEventDispatcher()));
        return new SimpleCommandBus(commandHandlerMap);
    }

    @Bean
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap = new HashMap<>();
        queryHandlerMap.put(RetrieveUserById.class, new RetrieveUserByIdHandler(userService()));
        queryHandlerMap.put(RetrieveUsers.class, new RetrieveUsersHandler(userService()));
        queryHandlerMap.put(RetrieveMembershipById.class, new RetrieveMembershipByIdHandler(memberService()));
        queryHandlerMap.put(RetrieveMemberships.class, new RetrieveMembershipsHandler(memberService()));
        queryHandlerMap.put(RetrieveProjectById.class, new RetrieveProjectByIdHandler(projectService()));
        queryHandlerMap.put(RetrieveProjects.class, new RetrieveProjectsHandler(projectService()));
        queryHandlerMap.put(RetrieveProjectsByManagerId.class, new RetrieveProjectsByManagerIdHandler(projectService()));
        queryHandlerMap.put(RetrieveScheduledPaymentById.class, new RetrieveScheduledPaymentByIdHandler(scheduledPaymentService()));
        queryHandlerMap.put(RetrieveScheduledPayments.class, new RetrieveScheduledPaymentsHandler(scheduledPaymentService()));
        return new SimpleQueryBus(queryHandlerMap);
    }
}
