SUMMARY = "Timezone data"
HOMEPAGE = "http://www.iana.org/time-zones"
SECTION = "base"
LICENSE = "PD & BSD & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c679c9d6b02bc2757b3eaf8f53c43fba"

DEPENDS = "tzcode-native"

SRC_URI = "http://www.iana.org/time-zones/repository/releases/tzdata${PV}.tar.gz;name=tzdata"
UPSTREAM_CHECK_URI = "http://www.iana.org/time-zones"

SRC_URI[tzdata.md5sum] = "96a985bb8eeab535fb8aa2132296763a"
SRC_URI[tzdata.sha256sum] = "547161eca24d344e0b5f96aff6a76b454da295dc14ed4ca50c2355043fb899a2"

inherit allarch

RCONFLICTS_${PN} = "timezones timezone-africa timezone-america timezone-antarctica \
             timezone-arctic timezone-asia timezone-atlantic \
             timezone-australia timezone-europe timezone-indian \
             timezone-iso3166.tab timezone-pacific timezone-zone.tab"

S = "${WORKDIR}"

DEFAULT_TIMEZONE ?= "Europe/London"
INSTALL_TIMEZONE_FILE ?= "1"

TZONES= "africa antarctica asia australasia europe northamerica southamerica  \
         factory etcetera backward systemv \
        "

# pacificnew 

do_compile () {
        for zone in ${TZONES}; do \
            ${STAGING_BINDIR_NATIVE}/zic -d ${WORKDIR}${datadir}/zoneinfo -L /dev/null \
                -y ${S}/yearistype.sh ${S}/${zone} ; \
            ${STAGING_BINDIR_NATIVE}/zic -d ${WORKDIR}${datadir}/zoneinfo/posix -L /dev/null \
                -y ${S}/yearistype.sh ${S}/${zone} ; \
            ${STAGING_BINDIR_NATIVE}/zic -d ${WORKDIR}${datadir}/zoneinfo/right -L ${S}/leapseconds \
                -y ${S}/yearistype.sh ${S}/${zone} ; \
        done
}

do_install () {
        install -d ${D}/$exec_prefix ${D}${datadir}/zoneinfo
        cp -pPR ${S}/$exec_prefix ${D}/
        # libc is removing zoneinfo files from package
        cp -pP "${S}/zone.tab" ${D}${datadir}/zoneinfo
        cp -pP "${S}/zone1970.tab" ${D}${datadir}/zoneinfo
        cp -pP "${S}/iso3166.tab" ${D}${datadir}/zoneinfo

        # Install default timezone
        if [ -e ${D}${datadir}/zoneinfo/${DEFAULT_TIMEZONE} ]; then
            install -d ${D}${sysconfdir}
            if [ "${INSTALL_TIMEZONE_FILE}" = "1" ]; then
                echo ${DEFAULT_TIMEZONE} > ${D}${sysconfdir}/timezone
            fi
            ln -s ${datadir}/zoneinfo/${DEFAULT_TIMEZONE} ${D}${sysconfdir}/localtime
        else
            bberror "DEFAULT_TIMEZONE is set to an invalid value."
            exit 1
        fi

        chown -R root:root ${D}
        rm -rf ${D}${datadir}/zoneinfo/posix
        rm -rf ${D}${datadir}/zoneinfo/right
}

pkg_postinst_${PN} () {
	etc_lt="$D${sysconfdir}/localtime"
	src="$D${sysconfdir}/timezone"

	if [ -e ${src} ] ; then
		tz=$(sed -e 's:#.*::' -e 's:[[:space:]]*::g' -e '/^$/d' "${src}")
	fi
	
	if [ -z "${tz}" ] ; then
		exit 0
	fi
	
	if [ ! -e "$D${datadir}/zoneinfo/${tz}" ] ; then
		echo "You have an invalid TIMEZONE setting in ${src}"
		echo "Your ${etc_lt} has been reset to Universal; enjoy!"
		tz="Universal"
		echo "Updating ${etc_lt} with $D${datadir}/zoneinfo/${tz}"
		if [ -L ${etc_lt} ] ; then
			rm -f "${etc_lt}"
		fi
		ln -s "${datadir}/zoneinfo/${tz}" "${etc_lt}"
	fi
}

# Packages primarily organized by directory with a major city
# in most time zones in the base package

PACKAGES = "tzdata"

FILES_${PN} = "${datadir}/zoneinfo/* \
		${datadir}/zoneinfo/*.* \
		${sysconfdir}/localtime \
		${sysconfdir}/timezone"

CONFFILES_${PN} += "${@ "${sysconfdir}/timezone" if bb.utils.to_boolean(d.getVar('INSTALL_TIMEZONE_FILE')) else "" }"
CONFFILES_${PN} += "${sysconfdir}/localtime"
