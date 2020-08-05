DESCRIPTION = "serviceapp service for enigma2"
AUTHOR = "Maroš Ondrášek <mx3ldev@gmail.com>"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "enigma2 uchardet openssl"
RDEPENDS_${PN} = "enigma2 uchardet openssl python-json"

SMALLFL = "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "gstplayer", "exteplayer3 gstplayer", d)}"
RRECOMMENDS_${PN} = "${@bb.utils.contains("MACHINE_FEATURES", "exteplayeronly", "exteplayer3", "${SMALLFL}", d)}"

pkg_postinst_${PN}_exteplayeronly() {
	touch $D${sysconfdir}/enigma2/serviceapp_replaceservicemp3
	if [ -e $D${sysconfdir}/enigma2/settings ]
	then
		sed -i '/config.plugins.serviceapp.servicemp3.player=/d' $D${sysconfdir}/enigma2/settings
		sed -i '/config.plugins.serviceapp.servicemp3.replace=/d' $D${sysconfdir}/enigma2/settings
		echo "config.plugins.serviceapp.servicemp3.player=exteplayer3" >> $D${sysconfdir}/enigma2/settings
		echo "config.plugins.serviceapp.servicemp3.replace=true" >> $D${sysconfdir}/enigma2/settings
	else
		echo "config.plugins.serviceapp.servicemp3.player=exteplayer3" > $D${sysconfdir}/enigma2/settings
		echo "config.plugins.serviceapp.servicemp3.replace=true" >> $D${sysconfdir}/enigma2/settings
	fi
}

SRC_URI = "git://github.com/OpenVisionE2/serviceapp.git;branch=develop"

S = "${WORKDIR}/git"

inherit autotools gitpkgv pythonnative pkgconfig gettext rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

EXTRA_OECONF = "\
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
	"

FILES_${PN} = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/*.pyo \
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/locale/*/LC_MESSAGES/ServiceApp.mo \
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/serviceapp.so"

FILES_${PN}-dev = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/serviceapp.la"

CXXFLAGS_append_sh4 += "-std=c++11 -fPIC -fno-strict-aliasing "

pkg_postinst_${PN}_sh4() {
	touch $D${sysconfdir}/enigma2/serviceapp_replaceservicemp3
	if [ -e $D${sysconfdir}/enigma2/settings ]
	then
		sed -i '/config.plugins.serviceapp.servicemp3.player=/d' $D${sysconfdir}/enigma2/settings
		sed -i '/config.plugins.serviceapp.servicemp3.replace=/d' $D${sysconfdir}/enigma2/settings
		echo "config.plugins.serviceapp.servicemp3.player=exteplayer3" >> $D${sysconfdir}/enigma2/settings
		echo "config.plugins.serviceapp.servicemp3.replace=true" >> $D${sysconfdir}/enigma2/settings
	else
		echo "config.plugins.serviceapp.servicemp3.player=exteplayer3" > $D${sysconfdir}/enigma2/settings
		echo "config.plugins.serviceapp.servicemp3.replace=true" >> $D${sysconfdir}/enigma2/settings
	fi
}
