<%@ page import="com.simplon.cnss.Config.BaseUrl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
    <title>Welcome to Macnss</title>
</head>
<body>
<div class="min-h-screen flex">
    <div class="flex-1 flex flex-col justify-center py-12 px-4 sm:px-6 lg:flex-none lg:px-20 xl:px-24">
        <div class="mx-auto w-full max-w-sm lg:w-96">
            <div>
                <div class="flex justify-center">
                    <img class="h-50 w-auto" src="https://www.cnss.ma/sites/all/themes/cnss2/img/logo.png"
                         alt="Workflow">
                </div>
                <h2 class="mt-6 text-3xl font-extrabold text-gray-900">Welcome To Macnss</h2>
                <p class="mt-2 text-sm text-gray-600">
                    <a href="#" class="font-medium text-indigo-600 hover:text-indigo-500"> Sign in to you account </a>
                </p>
            </div>

            <div class="mt-8">
                <div>
                    <div class="mt-6 relative">
                        <div class="absolute inset-0 flex items-center" aria-hidden="true">
                            <div class="w-full border-t border-gray-300"></div>
                        </div>
                        <div class="relative flex justify-center text-sm">
                            <span class="px-2 bg-white text-gray-500"> Or continue with </span>
                        </div>
                    </div>
                </div>

                <div class="mt-6">
                    <form action="<%=BaseUrl.BASE_URL%>users/login" method="POST" class="space-y-6">
                        <div>
                            <label for="email" class="block text-sm font-medium text-gray-700"> Email address </label>
                            <div class="mt-1">
                                <input id="email" name="email" type="email" autocomplete="email" required
                                       class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                            </div>
                        </div>

                        <div class="space-y-1">
                            <label for="password" class="block text-sm font-medium text-gray-700"> Password </label>
                            <div class="mt-1">
                                <input id="password" name="password" type="password" autocomplete="current-password"
                                       required
                                       class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                            </div>
                        </div>
                        <div>
                            <label>Agent</label>
                            <input name="role" type="radio" value="agent" checked>
                            <label>Patient</label>
                            <input name="role" type="radio" value="patient">
                        </div>

                        <div>
                            <button type="submit"
                                    class="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">
                                Sign in
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="hidden lg:block relative w-0 flex-1">
        <lottie-player src="https://assets7.lottiefiles.com/packages/lf20_rli35wrb.json" background="transparent"
                       speed="1"
                       loop autoplay></lottie-player>
    </div>
</div>
</body>
</html>
