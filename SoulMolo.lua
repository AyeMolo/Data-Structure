local runserv = game:GetService("RunService")
local rep = game:GetService("ReplicatedStorage")
local lp = game:GetService("Players").LocalPlayer
local placeid = game.PlaceId
local player = game.Players.LocalPlayer
local character = player.Character or player.CharacterAdded:Wait()
local placeid = game.PlaceId


local notificationLibrary = loadstring(game:HttpGet("https://raw.githubusercontent.com/laagginq/ui-libraries/main/xaxas-notification/src.lua"))()
local notifications = notificationLibrary.new({            
    NotificationLifetime = 3, 
    NotificationPosition = "Middle",
    TextFont = Enum.Font.Code,
    TextColor = Color3.fromRGB(255, 255, 255),
    TextSize = 15,
    TextStrokeTransparency = 0, 
    TextStrokeColor = Color3.fromRGB(0, 0, 0)
})

notifications:BuildNotificationUI()
notifications:Notify("Molo Modified Addons Loaded")

local function soulhub()
    loadstring(game:HttpGet("https://api.luarmor.net/files/v3/loaders/dfe68fef122a9d30786798b2ced5cd9d.lua"))()
    notifications:Notify("soulhub has loaded") 
end

local function AntiVoid()
    loadstring(game:HttpGet("https://raw.githubusercontent.com/AyeMolo/Data-Structure/main/Antivoid.lua"))()
    notifications:Notify("AntiVoid has loaded") 
end

local function selectSlot()
    for _, v in pairs(lp.PlayerGui.MainMenu.MainMenu.Play.Slots:GetChildren()) do
        if (v.Name == "A" or v.Name == "B") and v.Frame.Info.Text == "<b>Race:</b> Hollow | <b>Grade:</b> Fishbone" then
            return v.Name
        end
    end
end

local function menu(time)
    task.wait(time)
    while task.wait(2.5) do
        workspace.Entities[lp.Name].CharacterHandler.Remotes.MainMenu:FireServer()
    end
end

if placeid == 14069678431 then
    local foundHRP = false
    for _, v in pairs(character:GetDescendants()) do
        if v:IsA("Part") and v.Name == "HumanoidRootPart" then
            foundHRP = true
            break
        end
    end
    if not foundHRP then
        newHRP()
    end
end

if placeid == 14067600077 then
    repeat task.wait() until lp.PlayerGui:FindFirstChild("MainMenu")
    local slot = selectSlot()
    rep.Remotes.Returnable:InvokeServer({["Method"] = "SelectSlot", ["SelectedSlot"] = slot})
    while task.wait(2.5) do
        rep.Remotes.TeleportEvent:FireServer()
    end
elseif placeid == 17047374266 or placeid == 14069678431 then
    repeat task.wait() until lp.PlayerGui:FindFirstChild("DisplayUI")
    task.spawn(function() menu(placeid == 17047374266 and 240 or 30) end)
    soulhub()
    runserv:Set3dRenderingEnabled(false)
end