# Creates the "feed", packages not required for the image
# but that should be built for the feed so that other
# components may use them and install on demand.

# Trick: We want to create the package index, and we don't actually
# package anything, so we "inherit" the package indexer recipe.
require recipes-core/meta/package-index.bb

# We have a GPLv2 license for this recipe...
require conf/license/openvision-gplv2.inc

# Depend on the image, so that it gets build
DEPENDS = "openvision-enigma2-image"

OPTIONAL_PACKAGES_BROKEN = ""
OPTIONAL_PACKAGES ?= ""
OPTIONAL_BSP_PACKAGES ?= ""

OPTIONAL_PACKAGES += "\
	astra-sm \
	autofs \
	autossh \
	ccextractor \
	ccid \
	cloudflare-dns \
	ctorrent \
	cups \
	davfs2 \
	dhrystone \
	diffutils \
	djmount \
	dosfstools \
	dreamci \
	dvblast \
	dvbsnoop \
	dvdfs \
	edid-decode \
	evtest \
	exfat-utils \
	exteplayer3 \
	fuse-exfat \
	${@bb.utils.contains("TARGET_ARCH", "sh4", "", "gdb", d)} \
	google-dns \
	grep \
	gstplayer \
	gstreamer1.0-libav \
	hddtemp \
	hdparm \
	inadyn-mt \
	inetutils \
	iperf3 \
	iproute2 \
	${@bb.utils.contains("MACHINE", "dm800", "", "iptraf lirc satipclient", d)} \
	iputils \
	joe \
	less \
	libbluray \
	libsdl2 \
	libudfread \
	mc \
	mediainfo \
	minisatip \
	mtd-utils \
	mtools \
	nano \
	nbench-byte \
	net-tools \
	netatalk \
	${@bb.utils.contains("TARGET_FPU", "soft", "", "nodejs", d)} \
	ntfs-3g \
	ntp \
	ofgwrite \
	openmultiboot \
	openresolv \
	openssh \
	openvpn \
	parted \
	picocom \
	ppp \
	procps \
	pv \
	pyload \
	python-beautifulsoup4 \
	python-futures \
	python-ipaddress \
	python-iso3166 \
	python-iso639 \
	python-isodate \
	python-js2py \
	python-lxml \
	python-mechanize \
	python-ntplib \
	python-pip \
	python-pyexecjs \
	python-requests \
	python-singledispatch \
	python-websocket \
	${@bb.utils.contains("TARGET_FPU", "soft", "", "rclone", d)} \
	rsync \
	rtorrent \
	sabnzbd \
	samba \
	screen \
	sed \
	shellinabox \
	smartmontools \
	sshfs-fuse \
	sshpass \
	strace \
	tcpdump \
	tmux \
	transmission \
	udpxy \
	unzip \
	upx \
	usb-modeswitch \
	usb-modeswitch-data \
	ushare \
	v4l-utils \
	vim \
	wget \
	wscan \
	yafc \
	zeroconf \
	zerotier \
	zip \
	zsh \
	${OPTIONAL_BSP_PACKAGES} \
	"

OPTIONAL_PACKAGES_remove_sh4 += "\
	lirc \
	nodejs \
	rclone \
	"

EXTRA_WIFI_DRIVERS += "\
	firmware-mt7601u \
	firmware-rt3070 \
	firmware-rt8188fu \
	firmware-rtl8192cufw \
	firmware-rtl8192eu \
	mt7601u \
	${@bb.utils.contains_any("MACHINE", "cube su980 dm800 dm500hd dm500hdv2 dm800se dm800sev2 dm7020hd dm7020hdv2 dm8000 xpeedlx3 sezammarvel mbultra beyonwizt4 atemionemesis vuuno4kse vuzero4k vuduo2 vusolo2 vusolose vuzero", "", "mt7603u", d)} \
	rt3070 \
	${@bb.utils.contains_any("MACHINE", "cube su980 dm800", "", "rt8188fu", d)} \
	${@bb.utils.contains_any("MACHINE", "cube su980 dm800", "", "rt8723a", d)} \
	rt8723bs \
	${@bb.utils.contains_any("MACHINE", "cube su980 dm800 dm500hd dm500hdv2 dm800se dm800sev2 dm7020hd dm7020hdv2 dm8000 ixusszero ixussone dm820 dm7080 dm520", "", "rt8812au", d)} \
	${@bb.utils.contains("TARGET_ARCH", "sh4", "", "rt8822bu", d)} \
	rtl8188eu \
	${@bb.utils.contains_any("MACHINE", "et5x00 et6x00 et9x00 vuduo vusolo vuuno vuultimo osmio4k osmio4kplus osmini4k cube su980 dm800 dm500hd dm500hdv2 dm800se dm800sev2 dm7020hd dm7020hdv2 dm8000 force1 force1plus iqonios100hd iqonios200hd iqonios300hd iqonios300hdv2 mediabox optimussos1 optimussos1plus optimussos2 optimussos2plus optimussos3plus tm2t tmnano2super tmnano2t tmnano3t tmnano tmsingle tmtwin worldvisionf1 worldvisionf1plus azboxhd azboxme azboxminime maram9 c300 c300pro c400plus k1plus k1pro k2pro k2prov2 k3pro kvim2 alien4 ixusszero ixussone ventonhdx sezam5000hd mbtwin beyonwizt3 gb800ue gb800solo gb800se dm820 dm7080 dm520 x8hp wetekhub wetekplay2  wetekplay", "", "rtl8189es", d)} \
	rtl8192cu \
	${@bb.utils.contains_any("MACHINE", "osmio4k osmio4kplus osmini4k dm800", "", "rt8814au rtl8192eu", d)} \
	"

EXTRA_WIFI_DRIVERS_remove_cube += "\
	rt8723bs \
	rt8814au \
	rt8822bu \
	"

EXTRA_WIFI_DRIVERS_remove_dm800 += "\
	rt8723bs \
	rt8814au \
	rt8822bu \
	"

EXTRA_WIFI_DRIVERS_remove_su980 += "\
	rt8723bs \
	rt8814au \
	rt8822bu \
	"

EXTRA_WIFI_DRIVERS_remove_sh4 += "\
	mt7603u \
	rt8814au \
	rtl8189es \
	"

OPTIONAL_BSP_ENIGMA2_PACKAGES ?= ""

ENIGMA2_OPTIONAL += "\
	cdtextinfo \
	channelsettings-enigma2-meta \
	dvb-usb-drivers-meta \
	${@bb.utils.contains_any("MACHINE_FEATURES", "bwlcd96 bwlcd128 bwlcd140 bwlcd255 colorlcd220 colorlcd390 colorlcd400 colorlcd480 colorlcd720 colorlcd800", "enigma2-display-skins", "", d)} \
	enigma2-pliplugins \
	${@bb.utils.contains("EXTRA_IMAGEDEPENDS", "vuplus-tuner-turbo", "enigma2-plugin-drivers-dvb-usb-turbo", "", d)} \
	enigma2-plugin-drivers-usbserial \
	enigma2-plugin-extensions-arabicsavior \
	enigma2-plugin-extensions-automatic-fullbackup \
	enigma2-plugin-extensions-backupsuite \
	enigma2-plugin-extensions-bhweather \
	enigma2-plugin-extensions-blurayplayer \
	enigma2-plugin-extensions-dlnabrowser \
	enigma2-plugin-extensions-dlnaserver \
	enigma2-plugin-extensions-dreamplex \
	enigma2-plugin-extensions-e2iplayer \
	enigma2-plugin-extensions-e2iplayer-deps \
	enigma2-plugin-extensions-epgimport \
	enigma2-plugin-extensions-fontinfo \
	enigma2-plugin-extensions-hdmitest \
	enigma2-plugin-extensions-historyzapselector \
	enigma2-plugin-extensions-install-exteplayer3 \
	enigma2-plugin-extensions-install-ffmpeg \
	enigma2-plugin-extensions-install-gstplayer \
	enigma2-plugin-extensions-keyadder \
	${@bb.utils.contains_any("MACHINE_FEATURES", "azbox", "enigma2-plugin-extensions-keymapconfig enigma2-plugin-extensions-rsiconfig enigma2-plugin-extensions-rsimediacenter enigma2-plugin-systemplugins-ofwlauncher enigma2-plugin-extensions-aziptv enigma2-plugin-extensions-azplay", "", d)} \
	${@bb.utils.contains_any("MACHINE_FEATURES", "colorlcd colorlcd220 colorlcd390 colorlcd400 colorlcd480 colorlcd720 colorlcd800 bwlcd140 bwlcd255", "enigma2-plugin-extensions-lcd4linux", "", d)} \
	enigma2-plugin-extensions-managerautofs \
	enigma2-plugin-extensions-merlininfo \
	enigma2-plugin-extensions-modifyplifullhd \
	enigma2-plugin-extensions-moviemanager \
	enigma2-plugin-extensions-openmultiboot \
	enigma2-plugin-extensions-raedquicksignal \
	enigma2-plugin-extensions-refreshbouquet \
	${@bb.utils.contains_any("MACHINE", "cube su980 raspberrypi raspberrypi0", "", "enigma2-plugin-extensions-sdgradio", d)} \
	enigma2-plugin-extensions-tmbd \
	enigma2-plugin-extensions-vcs \
	enigma2-plugin-extensions-weathermsn \
	enigma2-plugin-extensions-xmodem \
	enigma2-plugin-extensions-yahooweather \
	enigma2-plugin-extensions-youtube \
	enigma2-plugin-security-firewall \
	enigma2-plugin-skins-blacktransfhd-raed \
	enigma2-plugin-skins-bundesligafhd-raed \
	enigma2-plugin-skins-cinogripli \
	enigma2-plugin-skins-dreamplexskins \
	enigma2-plugin-skins-glamouraurafhd \
	enigma2-plugin-skins-hdlinesuper-raed \
	enigma2-plugin-skins-iflatfhd \
	enigma2-plugin-skins-kravenfhd \
	enigma2-plugin-skins-kravenhd \
	enigma2-plugin-skins-kravenvb \
	enigma2-plugin-skins-maxfhdxta-raed \
	enigma2-plugin-skins-metrix-vision \
	enigma2-plugin-skins-mxblack-raed \
	enigma2-plugin-skins-mxhq9b-raed \
	enigma2-plugin-skins-mx-hq7 \
	enigma2-plugin-skins-mx-hq9w \
	enigma2-plugin-skins-mxsline-raed \
	enigma2-plugin-skins-octetfhd \
	enigma2-plugin-skins-octetsd \
	enigma2-plugin-skins-openvix \
	enigma2-plugin-skins-pli-hd-fullnight \
	enigma2-plugin-skins-sevenhd \
	enigma2-plugin-skins-simple-gray-hd \
	enigma2-plugin-skins-turbo-raed \
	enigma2-plugin-skins-turquoisehd \
	enigma2-plugin-skins-universehd \
	enigma2-plugin-skins-xionhdf \
	enigma2-plugin-skins-whitetransfhd-raed \
	enigma2-plugin-systemplugins-crossepg \
	enigma2-plugin-systemplugins-extnumberzap \
	enigma2-plugin-systemplugins-extrafancontrol \
	enigma2-plugin-systemplugins-hrtunerproxy \
	${@bb.utils.contains("MACHINE_FEATURES", "micom", "enigma2-plugin-systemplugins-micomupgrade" , "", d)} \
	enigma2-plugin-systemplugins-mountmanager \
	enigma2-plugin-systemplugins-netspeedtest \
	enigma2-plugin-systemplugins-newvirtualkeyboard \
	enigma2-plugin-systemplugins-radiotimesemulator \
	enigma2-plugin-systemplugins-serviceapp \
	enigma2-plugin-systemplugins-signalfinder \
	enigma2-plugin-systemplugins-quadpip \
	enigma2-plugins \
	enigma2-skins \
	libcrypto-compat \
	meta-enigma2-dvdburn \
	packagegroup-openplugins \
	picons-enigma2-meta \
	softcams-enigma2-meta \
	${OPTIONAL_BSP_ENIGMA2_PACKAGES} \
	"

DEPENDS += "${OPTIONAL_PACKAGES} ${ENIGMA2_OPTIONAL} ${EXTRA_WIFI_DRIVERS} enigma2-2boom-plugins"	
