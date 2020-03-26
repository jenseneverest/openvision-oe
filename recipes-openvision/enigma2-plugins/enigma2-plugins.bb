SUMMARY = "Original plugins for Enigma2"
MAINTAINER = "Open Vision Developers"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools-brokensep gitpkgv pythonnative pkgconfig gettext rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/enigma2-plugins.git;protocol=http"

S = "${WORKDIR}/git"

PACKAGES_DYNAMIC = "enigma2-plugin-(?!vision-).*"

PROVIDES = "\
    enigma2-plugin-extensions-advancedmovieselection \
    enigma2-plugin-extensions-aihdcontroler \
    enigma2-plugin-extensions-antiscrollbar \
    enigma2-plugin-extensions-ardmediathek \
    enigma2-plugin-extensions-audiorestart \
    enigma2-plugin-extensions-audiosync \
    enigma2-plugin-extensions-autotimer \
    enigma2-plugin-extensions-babelzapper \
    enigma2-plugin-extensions-birthdayreminder \
    enigma2-plugin-extensions-bitrateviewer \
    enigma2-plugin-extensions-bmediacenter \
    enigma2-plugin-extensions-bonjour \
    enigma2-plugin-extensions-cdinfo \
    enigma2-plugin-extensions-curlytx \
    enigma2-plugin-extensions-dreamexplorer \
    enigma2-plugin-extensions-dreamirc \
    enigma2-plugin-extensions-dvdbackup \
    enigma2-plugin-extensions-dyndns \
    enigma2-plugin-extensions-easyinfo \
    enigma2-plugin-extensions-easymedia \
    enigma2-plugin-extensions-ecasa \
    enigma2-plugin-extensions-eibox \
    enigma2-plugin-extensions-elektro \
    enigma2-plugin-extensions-emailclient \
    enigma2-plugin-extensions-emission \
    enigma2-plugin-extensions-eparted \
    enigma2-plugin-extensions-epgbackup \
    enigma2-plugin-extensions-epgrefresh \
    enigma2-plugin-extensions-epgsearch \
    enigma2-plugin-extensions-esame \
    enigma2-plugin-extensions-fancontrol2 \
    enigma2-plugin-extensions-filebrowser \
    enigma2-plugin-extensions-flashexpander \
    enigma2-plugin-extensions-fritzcall \
    enigma2-plugin-extensions-fstabeditor \
    enigma2-plugin-extensions-ftpbrowser \
    enigma2-plugin-extensions-googlemaps \
    enigma2-plugin-extensions-growlee \
    enigma2-plugin-extensions-httpproxy \
    enigma2-plugin-extensions-imdb \
    enigma2-plugin-extensions-infobartunerstate \
    enigma2-plugin-extensions-kiddytimer \
    enigma2-plugin-extensions-lastfm \
    enigma2-plugin-extensions-letterbox \
    enigma2-plugin-extensions-logomanager \
    enigma2-plugin-extensions-mediadownloader \
    enigma2-plugin-extensions-menusort \
    enigma2-plugin-extensions-merlinepg \
    enigma2-plugin-extensions-merlinepgcenter \
    enigma2-plugin-extensions-merlinmusicplayer \
    enigma2-plugin-extensions-meteoitalia \
    enigma2-plugin-extensions-mosaic \
    enigma2-plugin-extensions-moviecut \
    enigma2-plugin-extensions-movieepg \
    enigma2-plugin-extensions-movielistpreview \
    enigma2-plugin-extensions-movieretitle \
    enigma2-plugin-extensions-moviesearch \
    enigma2-plugin-extensions-movieselectionquickbutton \
    enigma2-plugin-extensions-movietagger \
    enigma2-plugin-extensions-multirc \
    enigma2-plugin-extensions-mytube \
    enigma2-plugin-extensions-namezap \
    enigma2-plugin-extensions-ncidclient \
    enigma2-plugin-extensions-netcaster \
    enigma2-plugin-extensions-ofdb \
    enigma2-plugin-extensions-orfat \
    enigma2-plugin-extensions-orfteletext \
    enigma2-plugin-extensions-partnerbox \
    enigma2-plugin-extensions-permanentclock \
    enigma2-plugin-extensions-permanenttimeshift \
    enigma2-plugin-extensions-pipzap \
    enigma2-plugin-extensions-pluginhider \
    enigma2-plugin-extensions-pluginsort \
    enigma2-plugin-extensions-podcast \
    enigma2-plugin-extensions-primetimemanager \
    enigma2-plugin-extensions-pushservice \
    enigma2-plugin-extensions-quickbutton \
    enigma2-plugin-extensions-reconstructapsc \
    enigma2-plugin-extensions-remotetimer \
    enigma2-plugin-extensions-rsdownloader \
    enigma2-plugin-extensions-satloader \
    enigma2-plugin-extensions-schiffe \
    enigma2-plugin-extensions-seekbar \
    enigma2-plugin-extensions-serienfilm \
    enigma2-plugin-extensions-seriesplugin \
    enigma2-plugin-extensions-shoutcast \
    enigma2-plugin-extensions-showclock \
    enigma2-plugin-extensions-simplerss \
    enigma2-plugin-extensions-startuptostandby \
    enigma2-plugin-extensions-subsdownloader2 \
    enigma2-plugin-extensions-sudoku \
    enigma2-plugin-extensions-svdrp \
    enigma2-plugin-extensions-tageditor \
    enigma2-plugin-extensions-teletext \
    enigma2-plugin-extensions-trafficinfo \
    enigma2-plugin-extensions-transmission \
    enigma2-plugin-extensions-tvcharts \
    enigma2-plugin-extensions-unwetterinfo \
    enigma2-plugin-extensions-valixdcontrol \
    enigma2-plugin-extensions-vierg \
    enigma2-plugin-extensions-virtualzap \
    enigma2-plugin-extensions-vlcplayer \
    enigma2-plugin-extensions-weatherplugin \
    enigma2-plugin-extensions-webcamviewer \
    enigma2-plugin-extensions-werbezapper \
    enigma2-plugin-extensions-youtubeplayer \
    enigma2-plugin-extensions-yttrailer \
    enigma2-plugin-extensions-zaphistorybrowser \
    enigma2-plugin-extensions-zapstatistic \
    enigma2-plugin-extensions-zdfmediathek \
    enigma2-plugin-systemplugins-3dsettings \
    enigma2-plugin-systemplugins-advhdmi \
    enigma2-plugin-systemplugins-aspectratioswitch \
    enigma2-plugin-systemplugins-automaticcleanup \
    enigma2-plugin-systemplugins-automatictimerlistcleanup \
    enigma2-plugin-systemplugins-automaticvolumeadjustment \
    enigma2-plugin-systemplugins-autoresolution \
    enigma2-plugin-systemplugins-mphelp \
    enigma2-plugin-systemplugins-networkbrowser \
    enigma2-plugin-systemplugins-pipservicerelation \
    enigma2-plugin-systemplugins-recordinfobar \
    enigma2-plugin-systemplugins-setpasswd \
    enigma2-plugin-systemplugins-startupservice \
    enigma2-plugin-systemplugins-systemtime \
    enigma2-plugin-systemplugins-vfdcontrol \
    enigma2-plugin-systemplugins-videocolorspace \
    enigma2-plugin-systemplugins-vps \
    "

DEPENDS = "\
    dvdbackup \
    enigma2 \
    libshowiframe \
    libtirpc \
    nmap \
    python-gdata \
    python-httplib2 \
    python-google-api-client \
    python-mutagen \
    python-pyopenssl \
    python-twisted \
    streamripper \
    "

RDEPENDS_${PN} = "python-ctypes"

CFLAGS += "-I${STAGING_INCDIR}/tirpc"
LDFLAGS += "-ltirpc"

RRECOMMENDS_enigma2-plugin-extensions-transmission = "transmission transmission-client"

DEPENDS_enigma2-plugin-extensions-bitrateviewer = "bitratecalc"
RDEPENDS_enigma2-plugin-extensions-bitrateviewer = "bitratecalc"

RREPLACES_enigma2-plugin-skincomponents-eventlist = "enigma2-plugin-components-eventlist"
RCONFLICTS_enigma2-plugin-skincomponents-eventlist = "enigma2-plugin-components-eventlist"

CONFFILES_${PN} += "${sysconfdir}/enigma2/movietags"
FILES_${PN} += " ${datadir}/enigma2 ${datadir}/fonts "
FILES_enigma2-plugin-extensions-bmediacenter += " ${libdir}/enigma2/python/Components/Renderer/LizWatches.pyo ${libdir}/enigma2/python/Components/Converter/LizExtraNumText.pyo"
FILES_enigma2-plugin-extensions-bmediacenter-src += " ${libdir}/enigma2/python/Components/Renderer/LizWatches.py ${libdir}/enigma2/python/Components/Converter/LizExtraNumText.py"
FILES_enigma2-plugin-skincomponents-channelselectionshorttitle += " ${libdir}/enigma2/python/Components/Converter/ChannelSelectionShortTitle.pyo"
FILES_enigma2-plugin-skincomponents-channelselectionshorttitle-src += " ${libdir}/enigma2/python/Components/Converter/ChannelSelectionShortTitle.py"
FILES_enigma2-plugin-skincomponents-eventlist += " ${libdir}/enigma2/python/Components/Renderer/EventListDisplay.pyo ${libdir}/enigma2/python/Components/Converter/EventList.pyo"
FILES_enigma2-plugin-skincomponents-eventlist-src += " ${libdir}/enigma2/python/Components/Renderer/EventListDisplay.py ${libdir}/enigma2/python/Components/Converter/EventList.py"
FILES_enigma2-plugin-skincomponents-eventposition += " ${libdir}/enigma2/python/Components/Converter/EventPosition.pyo"
FILES_enigma2-plugin-skincomponents-eventposition-src += " ${libdir}/enigma2/python/Components/Converter/EventPosition.py"
FILES_enigma2-plugin-skincomponents-weathercomponent += " ${libdir}/enigma2/python/Components/WeatherMSN.pyo ${libdir}/enigma2/python/Components/Converter/MSNWeather.pyo ${libdir}/enigma2/python/Components/Sources/MSNWeather.pyo ${libdir}/enigma2/python/Components/Renderer/MSNWeatherPixmap.pyo"
FILES_enigma2-plugin-skincomponents-weathercomponent-src += " ${libdir}/enigma2/python/Components/WeatherMSN.py ${libdir}/enigma2/python/Components/Converter/MSNWeather.py ${libdir}/enigma2/python/Components/Sources/MSNWeather.py ${libdir}/enigma2/python/Components/Renderer/MSNWeatherPixmap.py"
FILES_enigma2-plugin-skincomponents-reftopiconname += " ${libdir}/enigma2/python/Components/Converter/RefToPiconName.pyo"
FILES_enigma2-plugin-skincomponents-reftopiconname-src += " ${libdir}/enigma2/python/Components/Converter/RefToPiconName.py"

ALLOW_EMPTY_${PN} = "1"
PACKAGES += "${PN}-meta ${PN}-build-dependencies enigma2-plugin-skincomponents-channelselectionshorttitle enigma2-plugin-skincomponents-channelselectionshorttitle-src enigma2-plugin-skincomponents-eventlist enigma2-plugin-skincomponents-eventlist-src enigma2-plugin-skincomponents-eventposition enigma2-plugin-skincomponents-eventposition-src enigma2-plugin-skincomponents-weathercomponent enigma2-plugin-skincomponents-weathercomponent-src enigma2-plugin-skincomponents-reftopiconname enigma2-plugin-skincomponents-reftopiconname-src"
FILES_${PN}-meta = "${datadir}/meta"

EXTRA_OECONF = "\
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
    --without-debug \
    --with-boxtype=${MACHINE} \
    --with-boxbrand=${BOX_BRAND} \
    --with-arch=${TARGET_ARCH} \
    "

do_package_qa() {
}

python populate_packages_prepend() {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', '%s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.py$', 'enigma2-plugin-%s-src', '%s (source files)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', '%s (debug)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\/.*\.po$', 'enigma2-plugin-%s-po', '%s (translations)', recursive=True, match_path=True, prepend=True)
}
