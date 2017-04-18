<%@page import="java.util.Calendar"%>
<%@page import="org.c3s.web.context.ApplicationContext"%>
<%@page import="org.c3s.content.ContentObject"%>
<%@page import="org.c3s.edgo.utils.I10N"%>
<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<%
	ContentObject cms = ContentObject.getInstance();
	String lang_id = cms.getFixedParameter("language_id").toString();
%>
<div class="text-left h2">
	<% if ("ru".equals(lang_id)) { %>
		<ul>
			<li><a href="/edgo-client/EdGo.application">Автообновляемое приложение</a>&nbsp;&nbsp;<small><a href="/edgo-client/publish.htm">(информация)</a></small></li>
		</ul>
		<ul>
			<li><a href="https://github.com/hapsys/ed-go-client">Исходники на github</a></li>
		</ul>
    <% } else { %>
		<ul>
			<li><a href="/edgo-client/EdGo.application">Autoupdated application</a>&nbsp;&nbsp;<small><a href="/edgo-client/publish.htm">(information)</a></small></li>
		</ul>
		<ul>
			<li><a href="https://github.com/hapsys/ed-go-client">Source files on github</a></li>
		</ul>
	<% } %>
</div>
<p class="lead" style="margin-top: 50px;">
	Краткая инструкция по пользованию для альфа тестеров:
</p>
<p>
	<ol>
		<li>Регистрируемся на сайте <a href="/account/registration/">http://ed-go.ru/account/registration/</a></li>
		<li>Скачиваем альфа клиента <a href="/edgo-client/EdGo.application">http://ed-go.ru/edgo-client/EdGo.application</a></li>
		<li>Запускаем и устанавливаем EdGo.application (установится edgo-client)</li>
		<li>На сайте генерируем себе ключ для клиента <a href="/account/client-key/">http://ed-go.ru/account/client-key/</a> (Generate new key)</li>
		<li>В клиенте нажимаем на кнопку установки (ED-GO client settings), Копируем с сайта занчения "User ID" и "User Key". Нажимаем кнопку "Test"</li>
		<li>Если тест проходит, нажимаем "Save". В противном случае смотрим внимательно п.4-5</li>
		<li>Теперь кнопка "Start" должна быть активна.  Нажимаем ее. Программа проверяет последний присладнный евент и скант все файлы до этого эвента.</li>
		<li>Программа начинает отсылать неотосланые данные. Ждем пока не появится ожидающая надпись "Start scan new events"</li>
		<li>После этого программа ожидает новые события из игры и отсылает их на сервер.</li>
	</ol>
</p>
<p class="lead" style="margin-top: 30px;">
	Использование "Companion API":
</p>
<p>
	<ol>
		<li>Отсылать на сервер данные, полученные из "Companion API", можно в любой момент, если выполнен пердыдущий п.7</li>
		<li>В поля "E:D Account Email" и "Account Password" вбиваем свои данных входа в игру. !Внимание! Эти данные нигде не хранятся (см исходники клиента)</li>
		<li>Нажимаем кнопку "Next>>". Если данные уже отправлялись на сервер, то следующий пункт, скорее всего пропускается.</li>
		<li>Теперь клиент ожидает что вы введете проверочный код, который должен прийти на почту. Вводим его и нажимаем "Next>>".</li>
		<li>Если все нормально, то активируется кнопка "Send to Server". Получение данных занимает довольно продолжительное время. Ожидаем. Нажимаем "Cancel" (ну пока так)</li>
		<li>Если вы открываете "Companion API" и у вас уже активна кнопка "Send to Server", то можно просто нажать ее. Если после этого она дезактивируется, надо заного сделать п.2 (время жизни токенов прошло)</li>
	</ol>
</p>
<p class="lead" style="margin-top: 30px;">
	Замечания:
</p>
<p>
	<ol>
		<li>Иногда происходит сбой и и в окне лога появляется надпись "ERROR!!!". Надо попробовать перестартануть отправку: нажимаем "Stop", затем "Start".</li>
		<li>Если продолжается ошибки. То скорее всего сайт умер. Сигнализируйте об этом. (дискорд канал #pilot_soft или личка в дискоде для @haps#0468 )</li>
		<li>Если перенесена папка, хранящая журналы пилота, то ее необходимо слинковать (mklink) на старое место "C:\Users\&lt;USER&gt;\Saved Games\Frontier Developments\Elite Dangerous\"</li>
	</ol>
</p>

